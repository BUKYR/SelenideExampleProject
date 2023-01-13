import landingtestdata.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import landingtestdata.LandingTestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static landingtestdata.TestSource.*;


public class LandingTest extends TestBase {

    LandingTestData LandingTestData = new LandingTestData();


    @Test
    @DisplayName("Проверка валидации email input на странице 'Блог'")
    void emailInputValidationTest() {
        LandingTestData.openMainPage()
                .clickOnHeaderMenuElement(mediaText, blogText)
                .setEmailValue()
                .checkValidation();
    }

    @Test
    @DisplayName("Проверка раздела 'Проекты' в хедер меню и названия раздела")
    void pageOfProjectTitleTest() {
        LandingTestData.openMainPage()
                .clickOnHeaderMenuElement(companyText, projectsText)
                .checkTitleOfPage();
    }

    @ParameterizedTest
    @CsvSource(value =  {
            ".soc-vk, https://www.linkedin.com",
            ".soc-insta, https://vk.com/public217753469",
            ".soc-tw, https://consent.youtube.com"
    })
    @DisplayName("Проверка перехода на VK.COM по кнопке в хедер меню")
    void socialNetworkTest(String socialPin, String socialUrl) {
        LandingTestData.openMainPage()
                .clickOnSocialNetwork(socialPin)
                .checkSocialNetworkURL(socialUrl);
    }

       @Test
    @DisplayName("Проверка гамбергер-меню")
    void hamburgerBoxMenuTest() {
        LandingTestData.openMainPage()
                .clickOnHamburgerMenu()
                .checkContactsInHamburger();
    }

    @ParameterizedTest
    @CsvSource(value =  {
            ".lang-item-en, Company",
            ".lang-item-ru, Компания"
    })
    @DisplayName("Проверка локализации")
    void testOfLocalizationChange(String localItem, String companyText) {
        LandingTestData.openMainPage()
                .checkPageLocalization(localItem, companyText);
    }
}