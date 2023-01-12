package kz.bookcity.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BannerPage {

    //locators
    private SelenideElement bannerPageTitle = $(".page-title");

    //actions
    public BannerPage checkBannerResult(String textBannerPageTitle) {
        step("Проверка успешного перехода по рекламному баннеру", () -> {
            bannerPageTitle.shouldHave(text(textBannerPageTitle));
        });
        return this;
    }
}