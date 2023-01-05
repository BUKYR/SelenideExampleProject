import LandingTestData.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import LandingTestData.LandingTestData;


public class LandingTest extends TestBase {

    LandingTestData LandingTestData = new LandingTestData();

    @ParameterizedTest(name = "Поиск элементов хедера {1} на локали {0}")
    @CsvSource(value = {
            "/, Компания",
            "/en, Company"
    })
    void localeTest(String locale, String elementText) {
        LandingTestData.testLocale(locale, elementText);
    }

    @Test
    @DisplayName("Проверка перехода на YouTube по кнопке в хедере")
    void socialNetworkTest() {
        LandingTestData.socialNetworkTestYT();
    }

    @Test
    @DisplayName("Проверка хедер меню и раздела проекты")
    void listOfProjectTest() {
        LandingTestData.projectListTest();
    }

    @Test
    @DisplayName("Проверка гамбергер-меню")
    void hamburgBoxMenuTest() {
        LandingTestData.humburgTest();

    }
}