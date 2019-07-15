package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factory.ArticlePageObjectFactory;
import lib.ui.factory.MyListsPageObjectFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class ArticleTest extends CoreTestCase {

    @Test

    public void testSaveArticle() {


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.openArticleOption();

        if(Platform.getInstance().isIos()) {
        ArticlePageObject.tapToToolbar(); //убрать всплывающее окно
        } else {
            WebElement gotIt = driver.findElementByXPath("//*[contains(@text,'GOT IT')]");
            if (gotIt.isEnabled()) {
                gotIt.click();
                ArticlePageObject.tapToCreateFolder();
            } else {
                ArticlePageObject.tapToCreateFolder();
            }
        }

        if(Platform.getInstance().isIos()) {
            ArticlePageObject.tapSearchButton();
        } else {
            ArticlePageObject.createMyFolderList("Learning programming");
            SearchPageObject.typeSearchLine("Java");
        }

        SearchPageObject.clickByArticleWithSubstring("Island of Indonesia");
        ArticlePageObject.openArticleOption();

        if(Platform.getInstance().isIos()) {
            ArticlePageObject.tapActionTab();
            ArticlePageObject.tapActionTab();
        } else {
            ArticlePageObject.tapActionTab();
        }

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if(Platform.getInstance().isIos()){
            MyListsPageObject.openSavedList();
        } else {
            MyListsPageObject.openCreateList();
            MyListsPageObject.openFolderByName("Learning programming");
        }

        MyListsPageObject.swipeByArticleToDelete("Island of Indonesia");
        MyListsPageObject.findLastArticle("Programming language");
    }
}
