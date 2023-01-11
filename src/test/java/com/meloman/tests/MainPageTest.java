package com.meloman.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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
        step("Открытие главной страницы сайта 'bookcity'", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Проверка видимости логотипа", () -> {
            $(".main-logo").shouldBe(visible);
        });
    }


    @Test
    @DisplayName("Check empty input")
    void checkEmptyInput() {
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


    @Test
    void checkCatalog () {
        open("https://www.bookcity.kz/");
        $(".nav-list").$$("div").first().click();
        $("#mCSB_15_container").$$("ul li").first().hover();
        $("#mCSB_16_container").$(".submenu-list-title").shouldHave(text("Художественная литература"));
    }

    @Test
    void checkEmptyLoginTest () {
        open("https://www.bookcity.kz/");
        $(".header-top-row-link--login").click();
        $(".authentication-panel-wrap").$("button").click();
        $(".authentication-panel-wrap").$(".rich-text-input__error").shouldHave(text("Неверный логин или пароль."));
    }




    @Test
    @DisplayName("Check About us Title")
    void checkAboutUsTitleTest() {
        step("Открытие главной страницы сайта 'bookcity'", () -> {
            open("https://www.bookcity.kz/");
        });
        step("Переход на страницу 'О компании'", () -> {
            $(".header-top-row__item").$("a").$(withText("О компании")).click();
        });
        step("Проверка заголовка страницы 'О компании'", () -> {
            $(".banner__text").$("h1").shouldHave(text("О МАГАЗИНЕ"));
        });
    }
}
