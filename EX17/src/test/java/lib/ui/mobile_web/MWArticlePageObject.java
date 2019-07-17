package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        MENU_BOOKMARK = "css:#page-actions li#page-actions-watch a#ca-watch.mw-ui-icon-mf-watch";
        SEARCH_MENU_BUTTON = "css:button#searchIcon";
        REMOVE_MY_LIST_BUTTON = "#page-actions li#page-actions-watch a#ca-watch.mw-ui-icon-mf-watched";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";

    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}


