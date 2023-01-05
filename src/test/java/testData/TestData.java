package testData;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static testData.TestSource.*;

public class TestData {


    @BeforeAll
    public static void testBaseUrlConfiguration() {
        Configuration.baseUrl = "https://rit-it.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 50000;
    }

    public void open() {
        Selenide.open("/");
    }

    public TestData socialNetworkTestYT() {
        open();
        $(headerWrapper).$(topBar).$(socTW).click();
        switchTo().window(1);
        webdriver().shouldHave(url(youtubeUrl));

        return this;
    }
}


