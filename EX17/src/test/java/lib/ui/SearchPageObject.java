package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class SearchPageObject extends MainPageObject{

     protected static String

             SEARCH_INIT_ELEMENT ,
             SEARCH_INPUT,
             SEARCH_RESULT_BY_SUBSTRING_TPL ,
             CLICK_RESULT ,
             SEARCH_NOT_RESULT_FOUND,
             SEARCH_RESULT_ELEMENT;



    public SearchPageObject(RemoteWebDriver driver) {
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
        this.waitElementAndSendKey(SEARCH_INPUT, search_line,"Cannot find and type into search input",5);
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

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }

    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitElementAndClick(search_result_xpath,"Cannot find and click search result" +substring, 5);
    }


}
