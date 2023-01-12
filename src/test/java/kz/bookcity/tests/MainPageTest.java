package kz.bookcity.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTest {
    @BeforeAll
    static void beforeSettings() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Check logo")
    void checkLogoTest() {
        step("Открытие главной страницы сайта bookcity", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Проверка видимости логотипа", () -> {
            $(".main-logo").shouldBe(visible);
        });
    }


    @Test
    @DisplayName("Check empty input")
    void checkEmptyInputTest() {
        step("Проверка пустого поля для email", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Проверка пустого поля для email", () -> {
            $(".form-row_block").$("button").click();
        });
        step("Проверка пустого поля для email", () -> {
            $(".form-row_block").$(".rich-text-input__error").shouldHave(text("Заполните email"));
        });
    }

    String textForSearch = "гарри поттер";

    @Test
    @DisplayName("Check About us Title")
    void checkAboutUsTitleTest() {
        step("Открытие главной страницы сайта bookcity", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Переход на страницу О компании", () -> {
            $(".header-top-row").$(withText("О компании")).click();
        });
        step("Проверка заголовка страницы О компании", () -> {
            $(".banner__text").$("h1").shouldHave(text("О МАГАЗИНЕ"));
        });
    }



    @Test
    @DisplayName("Check search result")
    void checkSearchResultTest () {
        step("Открытие главной страницы сайта bookcity", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Ввод текста в поисковую строку", () -> {
            $("#inline_ajax_search").setValue(textForSearch).pressEnter();
        });
        step("Проверка результатов поиска", () -> {
            $(".catalog-section-info").shouldHave(text("По запросу “" + textForSearch + "” найдено"));
        });
    }


    @Test
    @DisplayName("Check add favourite")
    void checkAddFavouriteTest () {
        step("Открытие главной страницы сайта bookcity", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Ввод текста в поисковую строку", () -> {
            $("#inline_ajax_search").setValue(textForSearch).pressEnter();
        });
        step("Поиск нужного товара", () -> {
            $$(".catalog-grid__item").first().hover();
        });
        step("Добавление товара в избранные", () -> {
            $$(".catalog-grid__item").first().$(".product-card-hidden").$(".btn_like").click();
        });
        step("Переход на страницу Избранное", () -> {
            $(".btn-action-row").$(".btn-action_favorites").click();
        });
        step("Проверка наличия избранного товара", () -> {
            $(".catalog-section-header-info").shouldHave(text("Вы добавили 1 товар"));
        });
    }


    @Test
    @DisplayName("Check delete favourite")
    void checkDeleteFavouriteTest () {
        step("Открытие главной страницы сайта bookcity", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Ввод текста в поисковую строку", () -> {
            $("#inline_ajax_search").setValue(textForSearch).pressEnter();
        });
        step("Поиск нужного товара", () -> {
            $$(".catalog-grid__item").first().hover();
        });
        step("Добавление товара в избранные", () -> {
            $$(".catalog-grid__item").first().$(".product-card-hidden").$(".btn_like").click();
        });
        step("Переход на страницу Избранное", () -> {
            $(".btn-action-row").$(".btn-action_favorites").click();
        });
        step("Удаление товара из избранных", () -> {
            $(".catalog-section-header-link").click();
        });
        step("Проверка удаления товара из избранных", () -> {
            $(".personal-card__body").shouldHave(text("Вы еще не добавили ни одного товара в “Избранное”."));
        });
    }


    @Test
    @DisplayName("Check banner")
    void checkBannerTest () {
        step("Открытие главной страницы сайта bookcity", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Нажать на рекламный баннер", () -> {
            $(".billboard__image").click();
        });
        step("Проверка успешного перехода по рекламному баннеру", () -> {
            $(".page-title").shouldHave(text("Книги по 500 тенге"));
        });
    }









}
