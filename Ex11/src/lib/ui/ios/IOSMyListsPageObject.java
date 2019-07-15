package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
                MAIN_MENU = "id:Saved";
                ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
                TOOLBAR = "id:Toolbar";
    }

    public IOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
