package landingtestdata;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;


import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static landingtestdata.TestSource.*;
import static io.qameta.allure.Allure.step;

public class LandingTestData {

    public LandingTestData openMainPage() {
        Selenide.open("/en");
        $(".lang-item-ru").click();
        return this;
    }

    public LandingTestData choiсeHeadersItem() {
        step("Переход на страницу 'Блог'", () -> {
            $(headerWrapper).$(byText(mediaText)).hover();
            $(byText(blogText)).click();
        });
        return this;
    }

    public LandingTestData setEmailValue() {
    step("Ввод неправильного email", () -> {
            $(s2email).setValue(incorrectMail);
                    });
        return this;
    }
    public LandingTestData checkValidation() {
    $(subscribeButton).click();
    $(s2error).shouldHave(text(errorText));
        return this;
    }

    public LandingTestData clickOnSocialNetwork(String socialPin) {
        step("Поиск и клик по кнопке VK в хедере", () -> {
                    $(headerWrapper).$(topBar).$(socialPin).click();
                });
        return this;
    }
        public LandingTestData checkSocialNetworkURL(String socialUrl) {
        step("Переход на новую вкладку и проверка урла", () -> {
                    switchTo().window(1);
                    webdriver().shouldHave(url(socialUrl));
        });
        return this;
    }

    public LandingTestData clickOnHeaderMenuElement() {
       step("Поиск и клик по кнопке 'Проекты' в хедере", () -> {
                    $(headerWrapper).$(byText(companyRUText)).hover();
                    $(byText(projectsText)).click();
            });
        return this;
    }
    public LandingTestData checkTitleOfHeaderMenuElement() {
        step("На странице заголовок 'Проекты' ", () -> {
                    $(wrapper).$(content).shouldHave(text(projectsText));
            });
        return this;
    }

    public  LandingTestData clickOnHamburgerMenu() {
        step("Клик по гамбергер-меню", () -> {
                    $(humburgBox).click();
                });
        return this;
    }
    public  LandingTestData checkContactsInHamburger() {
        step("Проверка наличия раздела 'Контакты' в открывшемся меню", () -> {
                    $(popupWrapper).$(colInner).$(bigMenuCategory, 2).shouldHave(text(numberText), text(contactsText), text(emailText));
                 });
        return this;
    }

    public LandingTestData checkPageLocalization(String localItem, String companyText) {

        $(localItem).click();
        $(masthead).$(byText(companyText)).shouldBe(Condition.visible);
       return this;

}
}


