package kz.bookcity.tests;

import io.qameta.allure.Owner;
import kz.bookcity.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends TestBase {

    MainPage mainPage = new MainPage();

    String textErrorMessage = "Заполните email";

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check logo")
    void checkLogoTest() {
        mainPage.openPage()
                .checkLogo();
    }

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check empty input")
    void checkTextEmptyInputTest() {
        mainPage.openPage()
                .clickEmailButton()
                .checkEmptyInputError(textErrorMessage);
    }
}