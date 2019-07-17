package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String

    MENU_BOOKMARK,
    SEARCH_INIT_ELEMENT,
    CREATE_FOLDER,
    OK_BUTTON,
    SEARCH_MENU_BUTTON,
    TOOLBAR,
    OPEN_NAVIGATION,
    REMOVE_MY_LIST_BUTTON,
    ACTION_TAB;



    public ArticlePageObject(RemoteWebDriver driver) {
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

    public void removeArticleFromSavedIfItAdded()
    {
        if(this.isElementPresent(REMOVE_MY_LIST_BUTTON)){
            this.waitElementAndClick(REMOVE_MY_LIST_BUTTON, "Cannot find button to remove article",1);
            this.waitForElementPresent(REMOVE_MY_LIST_BUTTON, "Cannot find button to add an article to saved list after removing");
        }
    }

    public void tapActionTab(){

        if(Platform.getInstance().isMW()){
          this.removeArticleFromSavedIfItAdded();
        }

        this.waitElementAndClick(ACTION_TAB,"Cannot find 'Action tab'", 5);

    }

    public void openNavigation()
    {
        if(Platform.getInstance().isMW()) {
         this.waitElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button",5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform" +Platform.getInstance().getPlatformVar());
        }
    }

}
