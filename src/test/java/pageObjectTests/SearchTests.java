package pageObjectTests;

import org.testng.annotations.Test;
import pageObjects.*;

public class SearchTests extends BaseTest {

    @Test
    public void search_validProductSearch() {
        MainPage mainPage = new MainPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        mainPage.open(url);
        mainPage.productSearch("stainless work table");

        searchResultsPage.verifySearchResults("Table");

        productPage.addToCart();

        productPage.viewCart();

        cartPage.emptyCart();
    }
}
