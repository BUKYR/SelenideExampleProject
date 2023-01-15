package testdata;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;
import static testdata.TestSource.*;


public class LandingTestData {

    @Step("Открытие главной страницы")
    public LandingTestData openMainPage() {
                    Selenide.open("/en");
                    $(".lang-item-ru").click();
        return this;
    }

    @Step("Выбор элемента в хедере")
    public LandingTestData clickOnHeaderMenuElement(String menuItem, String subMenuItem) {
                    $(headerWrapper).$(byText(menuItem)).hover();
                    $(byText(subMenuItem)).click();

        return this;
    }

    @Step("Подстановка неверного значения")
    public LandingTestData setEmailValue() {
                    $(s2email).setValue(incorrectMail);
        return this;
    }

    @Step("Проверка валидации поля")
    public LandingTestData checkValidation() {
                    $(subscribeButton).click();
                    $(s2error).shouldHave(text(errorText));
        return this;
    }

    @Step("Клик на значок социальной сети")
    public LandingTestData clickOnSocialNetwork(String socialPin) {
                     $(headerWrapper).$(topBar).$(socialPin).click();
                     return this;
    }
    @Step("Проверка перехода на страницу социальной сети")
    public LandingTestData checkSocialNetworkURL(String socialUrl) {
                    switchTo().window(1);
                    webdriver().shouldHave(urlStartingWith(socialUrl));

        return this;
    }

    @Step("Проверка заголовка страницы")
    public LandingTestData checkTitleOfPage() {
                    $(wrapper).$(content).shouldHave(text(projectsText));
        return this;
    }
    @Step("Открытие гамбургер меню")
    public  LandingTestData clickOnHamburgerMenu() {
                    $(humburgBox).click();
        return this;
    }
    @Step("Проверка информации в меню")
    public  LandingTestData checkContactsInHamburger() {
                 $(popupWrapper).$(colInner).$(bigMenuCategory, 2).
                        shouldHave(text(numberText), text(contactsText), text(emailText));

        return this;
    }

    @Step("Проверка смены локализации")
    public LandingTestData checkPageLocalization(String localItem, String companyText) {
                 $(localItem).click();
                 $(masthead).$(byText(companyText)).shouldBe(Condition.visible);
       return this;

}
}


