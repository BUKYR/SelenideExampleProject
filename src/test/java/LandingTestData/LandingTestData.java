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
        Selenide.open("/");
    }

    public LandingTestData testEmail() {
        step("Открытие главной страницы", () -> {
            open();
        });
        step("Переход на страницу 'Блог'", () -> {
            $(headerWrapper).$(byText("Медиа")).hover();
            $(byText("Блог")).click();
        });
        step("Ввод неправильного email и проверка валидации", () -> {
            $("#s2email").setValue("test@test.com");
            $("[name=subscribe]").click();
            $(".s2_error").shouldHave(text("Извините, но это не похоже на email"));

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


