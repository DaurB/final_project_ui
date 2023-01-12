package kz.bookcity.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FavouritePage {

    //locators
    private SelenideElement favouriteProductStatus = $(".catalog-section-header-info"),
                            favouriteProductDeleteElement = $(".catalog-section-header-link"),
                            deletedProductStatus = $(".personal-card__body");

    //actions
    public FavouritePage checkFavouriteProduct(String textFavouriteProductStatus) {
        step("Проверка наличия избранного товара", () -> {
            favouriteProductStatus.shouldHave(text(textFavouriteProductStatus));
        });
        return this;
    }

    public FavouritePage deleteFavouriteProduct() {
        step("Удаление товара из избранных", () -> {
            favouriteProductDeleteElement.click();
        });
        return this;
    }

    public FavouritePage checkDeletedProduct(String textDeletedProduct) {
        step("Проверка удаления товара из избранных", () -> {
            deletedProductStatus.shouldHave(text(textDeletedProduct));
        });
        return this;
    }
}