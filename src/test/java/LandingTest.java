import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LandingTest extends TestData {

    TestData testData = new TestData ();


    @ParameterizedTest
    @CsvSource (value = {
            "/, Компания",
            "/en, Company"
    })
    void localeVerification(String locale, String elementText) {
        Selenide.open(locale);
        $("#masthead").$(byText(elementText)).shouldBe(Condition.visible);
    }

    @Test
    void socialNetworkTest() {
        testData.open();
        $(".header-wrapper").$("#top-bar").$(".soc-tw").click();
        switchTo().window(1);
        webdriver().shouldHave(url("https://www.youtube.com/channel/UCm-z4T_PfKAOTe-JlSZbaog"));
    }

    @Test
    void listOfProjectTest() {
        testData.open();
        $(".header-wrapper").$(byText("Компания")).hover();
        $(byText("Проекты")).click();
        $("#wrapper").$("#content").shouldHave(text("Проекты"));
    }

    @Test
    void hamburgBoxMenuTest() {
      testData.open();
        $(".hamburg-box").click();
        $(".popup-wrapper").$(".col-inner").$(".big-menu-category", 2).shouldHave(text("Контакты"));

    }

}
