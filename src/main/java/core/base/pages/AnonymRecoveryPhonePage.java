package core.base.pages;
import com.codeborne.selenide.SelenideElement;
import core.base.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPhonePage extends BasePage {

    private SelenideElement inputByPhoneNumber = $("[name='st.r.phone']");
    private SelenideElement inputCountry = $("[id='country']");
    private SelenideElement getCodeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля через номер телефона")
    private void verifyPageElements() {
        inputByPhoneNumber.shouldBe(visible);
        inputCountry.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }
}
