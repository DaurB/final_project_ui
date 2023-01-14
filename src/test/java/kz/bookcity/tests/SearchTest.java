package kz.bookcity.tests;

import io.qameta.allure.Owner;
import kz.bookcity.pages.MainPage;
import kz.bookcity.pages.SearchResultPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    String textForSearch = "гарри поттер";

    @Owner("Bibol Dauren")
    @Test
    @DisplayName("Check search result")
    void checkSearchResultTest () {
        mainPage.openPage()
                .searchText(textForSearch);
        searchResultPage.checkSearchResult(textForSearch);
    }
}