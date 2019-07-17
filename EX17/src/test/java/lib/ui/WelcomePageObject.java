package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static final  String
       STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
       STEP_TITLE_NEW_WAY_TITLE = "id:New ways to explore",
       STEP_ADD_PREFERRED_LINK = "id:Add or edit preferred languages",
       STEP_LEARN_MORE_ABOUT_LINK = "id:Learn more about data collected",
       NEXT_BUTTON = "id:Next",
       GET_STARTED_BUTTON = "id:Get started",
       SKIP_BUT = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,"Cannot find 'Learn more about Wikipedia'",10);
    }

    public void waitForTitleNewWays(){
        this.waitForElementPresent(STEP_TITLE_NEW_WAY_TITLE,"Cannot find 'New ways to explore'",10);
    }

    public void waitForAddPreferredLanguagesLink(){
        this.waitForElementPresent(STEP_ADD_PREFERRED_LINK,"Cannot find 'Add or edit preferred languages'",10);
    }

    public void waitForLearnMoreAboutDataLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_LINK,"Cannot find 'Learn more about data collected'",10);
    }

    public void clickNextButton(){
        this.waitElementAndClick(NEXT_BUTTON,"Cannot find and click Next link",10);
    }

    public void clickGetStartedButton(){
        this.waitElementAndClick(GET_STARTED_BUTTON,"Cannot find and click Next link",10);
    }

    public void clickSkip(){
        this.waitElementAndClick(SKIP_BUT,"Cannot find and click 'Skip_button'",10);
    }

}
