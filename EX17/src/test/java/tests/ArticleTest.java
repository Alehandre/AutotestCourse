package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.AutorizationPageObject;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factory.ArticlePageObjectFactory;
import lib.ui.factory.MyListsPageObjectFactory;
import lib.ui.factory.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class ArticleTest extends CoreTestCase {

    private static final String
    login = "AutoTest",
    password = "1234qwer";

    @Test

    public void testSaveArticle() {


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("rogramming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.openArticleOption();

        if(Platform.getInstance().isMW()){
            AutorizationPageObject Auth = new AutorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login,password);
            Auth.submitForm();

            //ArticlePageObject.openArticleOption();
        }


        if(Platform.getInstance().isIos()) {
        ArticlePageObject.tapToToolbar(); //убрать всплывающее окно
        } else if(Platform.getInstance().isAndroid()){
            WebElement gotIt = driver.findElementByXPath("//*[contains(@text,'GOT IT')]");
            if (gotIt.isEnabled()) {
                gotIt.click();
                ArticlePageObject.tapToCreateFolder();
            } else {
                ArticlePageObject.tapToCreateFolder();
            }
        } else {
            ArticlePageObject.tapSearchButton();
            SearchPageObject.typeSearchLine("Java");
        }

        if(Platform.getInstance().isIos()) {
            ArticlePageObject.tapSearchButton();
        } else if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.createMyFolderList("Learning programming");
            SearchPageObject.typeSearchLine("Java");
        }

        SearchPageObject.clickByArticleWithSubstring("sland of Indonesia");
        ArticlePageObject.openArticleOption();

        ArticlePageObject.openNavigation();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openMyWatchlist();
        MyListsPageObject.swipeByArticleToDelete("Java");
        MyListsPageObject.findLastArticle("JavaScript");

        if(Platform.getInstance().isIos()) {
            ArticlePageObject.tapActionTab();
            ArticlePageObject.tapActionTab();
        } else if(Platform.getInstance().isAndroid()){
            ArticlePageObject.tapActionTab();
        }


        if(Platform.getInstance().isIos()){
            MyListsPageObject.openSavedList();
            MyListsPageObject.swipeByArticleToDelete("Island of Indonesia");
            MyListsPageObject.findLastArticle("Programming language");
        } else if(Platform.getInstance().isAndroid()) {
            MyListsPageObject.openCreateList();
            MyListsPageObject.openFolderByName("Learning programming");
            MyListsPageObject.swipeByArticleToDelete("Island of Indonesia");
            MyListsPageObject.findLastArticle("Programming language");
        }


    }
}
