import LandingTestData.TestBase;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import LandingTestData.LandingTestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class LandingTest extends TestBase {

    LandingTestData LandingTestData = new LandingTestData();

    @Test
    @DisplayName("Проверка валидации email input на странице 'Блог'")
    void emailTest() {
        LandingTestData.testEmail();
    }

    @Disabled
    @Test
    @DisplayName("Проверка перехода на VK.COM по кнопке в хедере")
    void socialNetworkTest() {
        LandingTestData.socialNetworkTestVK();
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

    @Test
    @DisplayName("Проверка локализации")
    void testLocale() {
        LandingTestData
                .testLocaleRU()
                .testLocaleEN();
    }
}