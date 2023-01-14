package kz.bookcity.tests;

import io.qameta.allure.Owner;
import kz.bookcity.pages.BannerPage;
import kz.bookcity.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BannerTest extends TestBase {
    MainPage mainPage = new MainPage();
    BannerPage bannerPage = new BannerPage();

    String textBannerPageTitle = "Книги по 500 тенге";

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check banner")
    void checkBannerTest() {
        mainPage.openPage()
                .clickBanner();
        bannerPage.checkBannerResult(textBannerPageTitle);
    }
}
