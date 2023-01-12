package kz.bookcity.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AboutUsPage {

    //locators
    private SelenideElement aboutUsTitle = $(".banner__text").$("h1");

    //actions
    public AboutUsPage checkAboutUsTitle(String textAboutUsTitle) {
        step("Проверка заголовка страницы О компании", () -> {
            aboutUsTitle.shouldHave(text(textAboutUsTitle));
        });
        return this;
    }
}
