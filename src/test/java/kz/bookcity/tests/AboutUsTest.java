package kz.bookcity.tests;

import io.qameta.allure.Owner;
import kz.bookcity.pages.AboutUsPage;
import kz.bookcity.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AboutUsTest extends TestBase {
    MainPage mainPage = new MainPage();
    AboutUsPage aboutUsPage = new AboutUsPage();

    String textAboutUsTitle = "О МАГАЗИНЕ";

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check About us Title")
    void checkAboutUsTitleTest() {
        mainPage.openPage()
                .clickAboutUs();
        aboutUsPage.checkAboutUsTitle(textAboutUsTitle);
    }
}
