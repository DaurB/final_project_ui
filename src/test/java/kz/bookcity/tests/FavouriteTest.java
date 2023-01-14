package kz.bookcity.tests;

import io.qameta.allure.Owner;
import kz.bookcity.pages.FavouritePage;
import kz.bookcity.pages.MainPage;
import kz.bookcity.pages.SearchResultPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FavouriteTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    FavouritePage favouritePage = new FavouritePage();

    String textForSearch = "гарри поттер",
           textFavouriteProductStatus = "Вы добавили 1 товар",
           textDeletedProduct = "Вы еще не добавили ни одного товара в “Избранное”.";

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check add favourite")
    void checkAddFavouriteTest() {
        mainPage.openPage()
                .searchText(textForSearch);
        searchResultPage.chooseProduct()
                .addFavourite()
                .goToFavouritePage();
        favouritePage.checkFavouriteProduct(textFavouriteProductStatus);
    }

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check delete favourite")
    void checkDeleteFavouriteTest() {
        mainPage.openPage()
                .searchText(textForSearch);
        searchResultPage.chooseProduct()
                .addFavourite()
                .goToFavouritePage();
        favouritePage.deleteFavouriteProduct()
                .checkDeletedProduct(textDeletedProduct);
    }
}
