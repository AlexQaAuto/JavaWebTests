package tests;

import core.base.BaseTest;
import core.base.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmptyPasswordError extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.setAcceptPrivacyButton();
    }

    @Test
    public void EmptyPasswordError() {
        // Попытка входа с пустым паролем
        loginPage.emptyPassword("testest");

        // Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorPasswordMessageVisible(),"Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPage.getErrorPasswordMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

}
