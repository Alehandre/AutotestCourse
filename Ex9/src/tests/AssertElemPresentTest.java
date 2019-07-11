package tests;

import lib.CoreTestCase;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AssertElemPresentTest extends CoreTestCase {
    @Test
    public void testAssertElementPresent() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

        if (skip.isEnabled()) {
            skip.click();
            SearchPageObject.initSearchInput();
        } else {
            SearchPageObject.initSearchInput();
        }

        SearchPageObject.typeSearchLine("Java");
        MyListsPageObject.openFolderByName("Discography");
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue("We found need title", amount_of_search_results > 0);

    }
}
