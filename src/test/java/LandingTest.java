import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testData.TestData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LandingTest extends TestData {

    TestData testData = new TestData();

    @ParameterizedTest(name = "Поиск элементов хедера {1} на локали {0}")
    @CsvSource(value = {
            "/, Компания",
            "/en, Company"
    })
    @DisplayName("Проверка локализаций ru и en")
    void localeVerification(String locale, String elementText) {
        Selenide.open(locale);
        $("#masthead").$(byText(elementText)).shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Проверка перехода на YouTube по кнопке в хедере")
    void socialNetworkTest() {
        testData.socialNetworkTestYT();
    }

    @Test
    @DisplayName("Проверка хедер меню и раздела проекты")
    void listOfProjectTest() {
        testData.open();
        $(".header-wrapper").$(byText("Компания")).hover();
        $(byText("Проекты")).click();
        $("#wrapper").$("#content").shouldHave(text("Проекты"));
    }

    @Test
    @DisplayName("Проверка гамбергер-меню")
    void hamburgBoxMenuTest() {
        testData.open();
        $(".hamburg-box").click();
        $(".popup-wrapper").$(".col-inner").$(".big-menu-category", 2).shouldHave(text("Контакты"));

    }
}