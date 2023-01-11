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

    @ParameterizedTest
    @CsvSource(value =  {
            ".soc-vk, https://www.linkedin.com/company/2710371/admin/",
            ".soc-insta, https://vk.com/public217753469",
            ".soc-tw, https://www.youtube.com/channel/UCm-z4T_PfKAOTe-JlSZbaog"
    })
    @DisplayName("Проверка перехода на VK.COM по кнопке в хедере")
    void socialNetworkTest(String socialPin, String socialUrl) {
        LandingTestData.openMainPage().clickOnSocialNetwork(socialPin).checkSocialNetworkURL(socialUrl);
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