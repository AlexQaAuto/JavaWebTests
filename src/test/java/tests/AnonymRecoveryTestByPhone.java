package tests;

import core.base.BaseTest;
import core.base.pages.AnonymRecoveryPage;
import core.base.pages.AnonymRecoveryPhonePage;
import core.base.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;


public class AnonymRecoveryTestByPhone extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void AnonymRecoveryTestByPhone() {

        loginPage.goToRecovery();

        AnonymRecoveryPage recoveryPage = new AnonymRecoveryPage();

        // переход на страницу телефона
        recoveryPage.goToRecoveryByPhone();

        // проверка страницы
        new AnonymRecoveryPhonePage();

}
}