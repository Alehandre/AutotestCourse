package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

    protected static  String
    FOLDER_BY_NAME_TPL,
    MAIN_MENU ,
    SKIP_BUTTON ,
    LIST_BUTTON ,
    GOT_IT_BUTTON ,
    CREATE_LIST_BUTTON ,
    SWIPE_TITLE ,
    LAST_TITLE ,
    TOOLBAR,
            ARTICLE_BY_TITLE_TPL,
    SEARCH_LAST_TITLE ;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title){
        return  ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }

    public MyListsPageObject(AppiumDriver driver){
        super(driver);
    }

    public void openFolderByName(String name_of_folder){
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
    this.waitElementAndClick(folder_name_xpath,
            "Cannot find folder by name" +name_of_folder,
            5);
    }


    public void openCreateList(){
        this.waitElementAndClick(MAIN_MENU,
                "Cannot find button to open Main Menu",
                5);

        this.waitElementAndClick(SKIP_BUTTON,
                "Cannot find button 'NO THANKS'",
                5);

        this.waitElementAndClick(LIST_BUTTON,
                "Cannot find button 'My lists'",
                5);

        this.waitElementAndClick(GOT_IT_BUTTON,
                "Cannot find button 'GOT IT'",
                5);

        this.waitElementAndClick(CREATE_LIST_BUTTON,
                "Cannot find button to open Create list",
                5);
    }

    public void openSavedList(){
        this.waitElementAndClick(MAIN_MENU,
                "Cannot find button to open Main Menu",
                5);
    }


    public void swipeByArticleToDelete(String article_title){

        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(article_xpath,
                "Cannot find create article");

        if(Platform.getInstance().isIos()){
        this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        this.waitForElementNotPresent(article_xpath,
                "Cannot delete saved article",
                10);
    }

    public void findLastArticle(String article_title){
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitElementAndClick(article_xpath,
                "Cannot find 'Programming language'",
                10);

        this.waitForElementPresent(TOOLBAR,
                "Cannot find title Toolbar");
    }


}
