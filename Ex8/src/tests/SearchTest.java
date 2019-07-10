package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends CoreTestCase {
    @Test
    public void testSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

        if (skip.isEnabled()) {
            skip.click();
            SearchPageObject.initSearchInput();
        } else {
            SearchPageObject.initSearchInput();
        }

        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Programming language");
        SearchPageObject.waitForSearchResult("Island of Indonesia");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.expectElementDisappeared();
    }
}
