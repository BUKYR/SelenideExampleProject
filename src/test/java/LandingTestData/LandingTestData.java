package LandingTestData;

import AllureConfiguration.Attach;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static LandingTestData.TestSource.*;
import static io.qameta.allure.Allure.step;

public class LandingTestData {

    public void open() {
        Selenide.open("/");
    }

    public LandingTestData testLocale(String locale, String elementText) {
        step("Выбор локали", () -> {
                    Selenide.open(locale);
                });
        step("Проверка соответсвия элементов хедера выбранной локали", () -> {
                    $(masthead).$(byText(elementText)).shouldBe(Condition.visible);
                });
        return this;
    }


    public LandingTestData socialNetworkTestYT() {
        step("Открытие главной страницы", () -> {
                    open();
                });
        step("Поиск и клик по кнопке YouTube в хедере", () -> {
                    $(headerWrapper).$(topBar).$(socTW).click();
                });
        step("Переход на новую вкладку и проверка урла", () -> {
                    switchTo().window(1);
                    webdriver().shouldHave(url(youtubeUrl));
        });
        return this;
    }

    public LandingTestData projectListTest() {
        step("Открытие главной страницы", () -> {
                    open();
            });
        step("Поиск и клик по кнопке 'Проекты' в хедере", () -> {
                    $(headerWrapper).$(byText(companyText)).hover();
                    $(byText(projectsText)).click();
            });
        step("На странице заголовок 'Проекты' ", () -> {
                    $(wrapper).$(content).shouldHave(text(projectsText));
            });
        return this;
    }

    public  LandingTestData humburgTest() {
        step("Открытие главной страницы", () -> {
                      open();
                });
        step("Клик по гамбергер-меню", () -> {
                    $(humburgBox).click();
                });
        step("Проверка наличия раздела 'Контакты' в открывшемся меню", () -> {
                    $(popupWrapper).$(colInner).$(bigMenuCategory, 2).shouldHave(text(contactsText));
                 });
        return this;
    }


}


