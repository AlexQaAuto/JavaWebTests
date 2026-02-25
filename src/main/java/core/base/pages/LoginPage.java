package core.base.pages;
import com.codeborne.selenide.SelenideElement;
import core.base.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-l='t,sign_in']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton = $x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");

    // Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement googleButton = $("[data-l='t,google']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");

    // Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $(".input-e.login_error");
    private SelenideElement errorLoginMessage = $(".class=\".LoginForm-module__error___1xmAD vkuiCaption__sizeYNone vkuiCaption__level1 vkuiTypography__host vkuiTypography__normalize vkuiRootComponent__host");
    private SelenideElement errorPasswordMessage = $(".class=\".LoginForm-module__error___1xmAD vkuiCaption__sizeYNone vkuiCaption__level1 vkuiTypography__host vkuiTypography__normalize vkuiRootComponent__host");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }


    //Пустой логин
    @Step("Проверяем видимость сообщения об ошибке пустого логина")
    public boolean isErrorLoginMessageVisible() {
        return errorLoginMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке пустого логина")
    public String getErrorLoginMessageText() {
        return errorLoginMessage.shouldBe(visible).getText();
    }

    //Пустой пароль
    @Step("Проверяем видимость сообщения об ошибке пустого пароля")
    public boolean isErrorPasswordMessageVisible() {
        return errorPasswordMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке пустого пароля")
    public String getErrorPasswordMessageText() {
        return errorPasswordMessage.shouldBe(visible).getText();
    }


    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        passwordField.shouldBe(visible).click();
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с пустым логином")
    public void emptylogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с пустым паролем")
    public void emptyPassword(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }


    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {

        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {

        registrationButton.shouldBe(visible).click();
    }

    //Методы для перехода на страницы авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVk() {

        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Google")
    public void loginWithGoogle() {

        googleButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMailRu() {

        mailRuButton.shouldBe(visible).click();
    }
}