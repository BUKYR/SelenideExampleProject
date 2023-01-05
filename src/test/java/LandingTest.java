import LandingTestData.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import LandingTestData.LandingTestData;


public class LandingTest extends TestBase {

    LandingTestData LandingTestData = new LandingTestData();

    @Test
    @DisplayName("Проверка валидации email input на странице 'Блог'")
    void emailTest() {
        LandingTestData.testEmail();
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