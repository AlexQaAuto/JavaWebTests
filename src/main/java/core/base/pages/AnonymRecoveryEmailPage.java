package core.base.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryEmailPage extends BasePage {

    private SelenideElement emailInput = $("[name='st.email']");
    private SelenideElement submitButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем элементы страницы восстановления по email")
    private void verifyPageElements() {
        emailInput.shouldBe(visible);
        submitButton.shouldBe(visible);

    }
}