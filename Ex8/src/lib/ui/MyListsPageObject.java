package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject {

    public static final String
    FOLDER_BY_NAME_TPL = "//android.widget.TextView[@text='{FOLDER_NAME}']",
    MAIN_MENU = "//android.widget.ImageButton[@content-desc='Navigate up']",
    SKIP_BUTTON = "//android.widget.Button[@text='NO THANKS']",
    LIST_BUTTON = "//android.widget.FrameLayout[@content-desc='My lists']",
    GOT_IT_BUTTON = "//android.widget.TextView[@text='GOT IT']",
    CREATE_LIST_BUTTON = "//android.widget.TextView[@text='Learning programming']",
    SWIPE_TITLE = "//*[contains(@text,'Island of Indonesia')]",
    LAST_TITLE = "//*[@text='Programming language']",
    SEARCH_LAST_TITLE = "//android.view.View[@content-desc='JavaScript']";

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }

    public MyListsPageObject(AppiumDriver driver){
        super(driver);
    }

    public void openFolderByName(String name_of_folder){
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
    this.waitElementAndClick(By.xpath(folder_name_xpath),
            "Cannot find folder by name" +name_of_folder,
            5);
    }

    public void openCreateList(){
        this.waitElementAndClick(By.xpath(MAIN_MENU),
                "Cannot find button to open Main Menu",
                5);

        this.waitElementAndClick(By.xpath(SKIP_BUTTON),
                "Cannot find button 'NO THANKS'",
                5);

        this.waitElementAndClick(By.xpath(LIST_BUTTON),
                "Cannot find button 'My lists'",
                5);

        this.waitElementAndClick(By.xpath(GOT_IT_BUTTON),
                "Cannot find button 'GOT IT'",
                5);

        this.waitElementAndClick(By.xpath(CREATE_LIST_BUTTON),
                "Cannot find button to open Create list",
                5);
    }

    public void swipeByArticleToDelete(){
        this.swipeElementToLeft(By.xpath(SWIPE_TITLE),
                "Cannot find create article");

        this.waitForElementNotPresent(By.xpath(SWIPE_TITLE),
                "Cannot delete saved article",
                10);
    }

    public void findLastArticle(){
        this.waitElementAndClick(By.xpath(LAST_TITLE),
                "Cannot find 'Programming language'",
                10);

        this.waitForElementPresent(By.xpath(SEARCH_LAST_TITLE),
                "Cannot find title 'JavaScript'");
    }


}
