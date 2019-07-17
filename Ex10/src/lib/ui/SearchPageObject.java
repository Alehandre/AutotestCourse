package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String

    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[contains(@text,'{SUBSTRING}')]",
    //FIND_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']",
    CLICK_RESULT = "id:org.wikipedia:id/search_close_btn",
    SEARCH_RESULT = "xpath://android.view.View[@content-desc='Soundgarden discography']";



    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void initSearchInput()
    {
        this.waitElementAndClick(SEARCH_INIT_ELEMENT, "Not find element 'Search Wiki'", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitElementAndSendKey(SEARCH_INIT_ELEMENT,search_line,"Cannot find and type into search input",5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Cannot find search result with substring" +substring);
    }

    public void clickCancelSearch()
    {
        this.waitElementAndClick(CLICK_RESULT,"Not find element 'X'",5);
    }

    public void expectElementDisappeared()
    {
        this.waitForElementNotPresent(CLICK_RESULT,"'X' is still present on the page", 5);
    }

    public int getAmountOfFoundArticles(){

        return this.getAmountOfElements(SEARCH_RESULT);

    }
}
