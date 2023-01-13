package kz.bookcity.tests;

import kz.bookcity.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends TestBase {

    MainPage mainPage = new MainPage();

    String textErrorMessage = "Заполните email";

    @Test
    @DisplayName("Check logo")
    void checkLogoTest() {
        mainPage.openPage()
                .checkLogo();
    }

    @Test
    @DisplayName("Check empty input")
    void checkEmptyInputTest() {
        mainPage.openPage()
                .clickEmailButton()
                .checkEmptyInputError(textErrorMessage);
    }
}