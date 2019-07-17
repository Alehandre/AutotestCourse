package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://android.widget.TextView[@text='{TITLE}']";
                MAIN_MENU = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
                SKIP_BUTTON = "xpath://android.widget.Button[@text='NO THANKS']";
                LIST_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
                GOT_IT_BUTTON = "xpath://android.widget.TextView[@text='GOT IT']";
                CREATE_LIST_BUTTON = "xpath://android.widget.TextView[@text='Learning programming']";
                SWIPE_TITLE = "xpath://*[contains(@text,'Island of Indonesia')]";
                LAST_TITLE = "xpath://*[@text='Programming language']";
                SEARCH_LAST_TITLE = "xpath://android.view.View[@content-desc='JavaScript']";
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver)

    {
        super(driver);
    }
}
