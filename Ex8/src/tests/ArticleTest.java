package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class ArticleTest extends CoreTestCase {

    @Test

    public void testSaveArticle() {
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

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.openArticleOption();

        WebElement gotIt = driver.findElementByXPath("//*[contains(@text,'GOT IT')]");

        if (gotIt.isEnabled()) {
            gotIt.click();
            ArticlePageObject.tapToCreateFolder();
        } else {
            ArticlePageObject.tapToCreateFolder();
        }

        ArticlePageObject.createMyFolderList("Learning programming");
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Island of Indonesia");
        ArticlePageObject.tapActionTab();
        ArticlePageObject.openArticleOption();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName("Learning programming");
        MyListsPageObject.openCreateList();
        MyListsPageObject.swipeByArticleToDelete();
        MyListsPageObject.findLastArticle();
    }
}
