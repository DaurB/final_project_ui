package kz.bookcity.tests;

import kz.bookcity.pages.MainPage;
import kz.bookcity.pages.SearchResultPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    String textForSearch = "гарри поттер";

    @Test
    @DisplayName("Check search result")
    void checkSearchResultTest () {
        mainPage.openPage()
                .searchText(textForSearch);
        searchResultPage.checkSearchResult(textForSearch);
    }
}