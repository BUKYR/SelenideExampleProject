package LandingTestData;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static LandingTestData.TestSource.*;
import static io.qameta.allure.Allure.step;

public class LandingTestData {

    public void open() {
        Selenide.open("/en");
        $(".lang-item-ru").click();

    }

    public LandingTestData testEmail() {
        step("Открытие главной страницы", () -> {
            open();
        });
        step("Переход на страницу 'Блог'", () -> {
            $(headerWrapper).$(byText(mediaText)).hover();
            $(byText(blogText)).click();
        });
        step("Ввод неправильного email и проверка валидации", () -> {
            $(s2email).setValue(incorrectMail);
            $(subscribeButton).click();
            $(s2error).shouldHave(text(errorText));

        });

        return this;
    }


    public LandingTestData socialNetworkTestVK() {
        step("Открытие главной страницы", () -> {
                    open();
                });
        step("Поиск и клик по кнопке VK в хедере", () -> {
                    $(headerWrapper).$(topBar).$(socVK).click();
                });
        step("Переход на новую вкладку и проверка урла", () -> {
                    switchTo().window(1);
                    webdriver().shouldHave(url(vkUrl));
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

    public LandingTestData testLocaleRU() {
        step("Выбор локали RU", () -> {
            open();
        });
        step("Проверка соответсвия элементов хедера выбранной локали", () -> {
            $("#masthead").$(byText(companyText)).shouldBe(Condition.visible);
        });
        return this;
    }
    public LandingTestData testLocaleEN() {
        step("Выбор локали EN", () -> {
            Selenide.open("/en");
        });
        step("Проверка соответсвия элементов хедера выбранной локали", () -> {
            $("#masthead").$(byText(companyENText)).shouldBe(Condition.visible);
        });
        return this;
    }

}


