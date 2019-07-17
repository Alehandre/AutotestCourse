package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        MENU_BOOKMARK = "id:Save for later";
        TOOLBAR = "id:Toolbar";
        SEARCH_MENU_BUTTON = "id:Search Wikipedia";
        ACTION_TAB = "id:Back";

    }

    public IOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
