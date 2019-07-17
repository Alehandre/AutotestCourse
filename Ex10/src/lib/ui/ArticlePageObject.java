package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject {

    private static final String

    MENU_BOOKMARK = "id:org.wikipedia:id/article_menu_bookmark",
    SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/text_input",
    CREATE_FOLDER = "xpath://*[contains(@text,'Create new')]",
    OK_BUTTON = "xpath://*[@text='OK']",
    SEARCH_MENU_BUTTON = "xpath://android.widget.ImageView[@content-desc='Search Wikipedia']",
    ACTION_TAB = "id:org.wikipedia:id/page_actions_tab_layout";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openArticleOption()
    {
        this.waitElementAndClick(MENU_BOOKMARK, "Cannot find button to open article options", 5);
    }

    public void tapToCreateFolder()
    {
        this.waitElementAndClick(CREATE_FOLDER, "Cannot find button 'Create new'", 5);
    }

    public void createMyFolderList(String name_of_folder)
    {
        this.waitElementAndSendKey(SEARCH_INIT_ELEMENT, name_of_folder,"Cannot find search string input",5);

        this.waitElementAndClick(OK_BUTTON,"Cannot find 'OK' buttons",5);

        this.waitElementAndClick(SEARCH_MENU_BUTTON,"Cannot find button to open Search Menu",5);
    }

    public void tapActionTab(){

        this.waitElementAndClick(ACTION_TAB,"Cannot find 'Action tab'", 5);

    }

}
