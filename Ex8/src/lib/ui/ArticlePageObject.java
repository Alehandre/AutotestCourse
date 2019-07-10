package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject {

    private static final String

    MENU_BOOKMARK = "org.wikipedia:id/article_menu_bookmark",
    SEARCH_INIT_ELEMENT = "org.wikipedia:id/text_input",
    CREATE_FOLDER = "//*[contains(@text,'Create new')]",
    OK_BUTTON = "//*[@text='OK']",
    SEARCH_MENU_BUTTON = "//android.widget.ImageView[@content-desc='Search Wikipedia']",
    ACTION_TAB = "org.wikipedia:id/page_actions_tab_layout";


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openArticleOption()
    {
        this.waitElementAndClick(By.id(MENU_BOOKMARK), "Cannot find button to open article options", 5);
    }

    public void tapToCreateFolder()
    {
        this.waitElementAndClick(By.id(CREATE_FOLDER), "Cannot find button 'Create new'", 5);
    }

    public void createMyFolderList(String name_of_folder)
    {
        this.waitElementAndSendKey(By.id(SEARCH_INIT_ELEMENT), name_of_folder,"Cannot find search string input",5);

        this.waitElementAndClick(By.xpath(OK_BUTTON),"Cannot find 'OK' buttons",5);

        this.waitElementAndClick(By.xpath(SEARCH_MENU_BUTTON),"Cannot find button to open Search Menu",5);
    }

    public void tapActionTab(){

        this.waitElementAndClick(By.id(ACTION_TAB),"Cannot find 'Action tab'", 5);

    }

}
