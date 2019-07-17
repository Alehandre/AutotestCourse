package lib.ui.android;

//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        MENU_BOOKMARK = "id:org.wikipedia:id/article_menu_bookmark";
                SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/text_input";
                CREATE_FOLDER = "xpath://*[contains(@text,'Create new')]";
                OK_BUTTON = "xpath://*[@text='OK']";
                SEARCH_MENU_BUTTON = "xpath://android.widget.ImageView[@content-desc='Search Wikipedia']";
                ACTION_TAB = "id:org.wikipedia:id/page_actions_tab_layout";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
