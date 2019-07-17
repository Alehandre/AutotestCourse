package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factory.MyListsPageObjectFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AssertElemPresentTest extends CoreTestCase {
    @Test
    public void testAssertElementPresent() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Soundgarden");
        MyListsPageObject.openFolderByName("Discography");
        if(Platform.getInstance().isAndroid()){
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue("We found need title", amount_of_search_results > 0);}


    }
}
