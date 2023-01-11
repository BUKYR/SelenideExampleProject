import landingtestdata.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import landingtestdata.LandingTestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class LandingTest extends TestBase {

    LandingTestData LandingTestData = new LandingTestData();


    @Test
    @DisplayName("Проверка валидации email input на странице 'Блог'")
    void emailTest() {
        LandingTestData.openMainPage().choiсeHeadersItem().setEmailValue().checkValidation();
    }

    @Test
    @DisplayName("Проверка перехода на VK.COM по кнопке в хедере")
    void socialNetworkTest() {
        LandingTestData.openMainPage().clickOnSocialNetwork().clickOnSocialNetwork();
    }

    @Test
    @DisplayName("Проверка раздела 'Проекты' в хедер меню")
    void listOfProjectTest() {
        LandingTestData.openMainPage().clickOnHeaderMenuElement().checkTitleOfHeaderMenuElement();
    }


    @Test
    @DisplayName("Проверка гамбергер-меню")
    void hamburgBoxMenuTest() {
        LandingTestData.openMainPage().clickOnHamburgerMenu().checkContactsInHamburger();
    }

    @ParameterizedTest
    @CsvSource(value =  {
            ".lang-item-en, Company",
            ".lang-item-ru, Компания"
    })
    @DisplayName("Проверка локализации")
    void testLocale(String localItem, String companyText) {
        LandingTestData.openMainPage().checkPageLocalization(localItem, companyText);
    }
}