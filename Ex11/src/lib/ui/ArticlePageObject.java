package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String

    MENU_BOOKMARK,
    SEARCH_INIT_ELEMENT,
    CREATE_FOLDER,
    OK_BUTTON,
    SEARCH_MENU_BUTTON,
    TOOLBAR,
    ACTION_TAB ;



    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void tapToToolbar()
    {
        this.waitElementAndClick(TOOLBAR, "Cannot find button Toolbar",5);
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

    public void tapSearchButton()
    {
        this.waitElementAndClick(SEARCH_MENU_BUTTON,"Cannot find button to open Search Menu",5);
    }

    public void tapActionTab(){

        this.waitElementAndClick(ACTION_TAB,"Cannot find 'Action tab'", 5);

    }



}
