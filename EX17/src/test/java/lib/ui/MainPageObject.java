package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import lib.Platform;

import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    private static final String
    SKIP = "xpath://*[contains(@text,'SKIP')]";

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver)
    {
      this.driver=driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public WebElement waitForElementPresent(String locator, String error_message) {

        return waitForElementPresent(locator, error_message, 5);

    }

    public boolean isElementPresent(String locator)
    {
        return getAmountOfElements(locator)>0;
    }

    public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attempts)
    {
        int current_attempts = 0;
        boolean need_more_attempts = true;

        while(need_more_attempts){
            try{
                this.waitElementAndClick(locator,error_message,1);
                need_more_attempts = false;
            } catch (Exception e){
                if(current_attempts> amount_of_attempts){
                    this.waitElementAndClick(locator,error_message,1);
                }
            }
            ++ current_attempts;
        }
    }

    public WebElement waitElementAndClick(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitElementAndSendKey(String locator, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

  public void clickElementToTheRightUpperCorner(String locator, String error_message)
  {
      if(driver instanceof  AppiumDriver) {
          WebElement element = this.waitForElementPresent(locator + "/..", error_message);
          int right_x = element.getLocation().getX();
          int upper_y = element.getLocation().getY();
          int lower_y = upper_y + element.getSize().getHeight();
          int middle_y = (upper_y + lower_y) / 2;
          int width = element.getSize().getWidth();

          int point_to_click_x = (right_x + width) - 3;
          int point_to_click_y = middle_y;

          TouchAction action = new TouchAction((AppiumDriver) driver);
          action.tap(point_to_click_x, point_to_click_y).perform();
      } else {
          System.out.println("Method clickElementToTheRightUpperCorner() do nothing for platform" +Platform.getInstance().getPlatformVar());
      }
  }

    public void swipeElementToLeft(String locator, String error_message) {
        if(driver instanceof  AppiumDriver) {
            WebElement element = waitForElementPresent(locator, error_message, 10);
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;

            TouchAction action = new TouchAction((AppiumDriver)driver);
            action.press(right_x, middle_y);
            action.waitAction(300);
            if (Platform.getInstance().isAndroid()) {
                action.moveTo(left_x, middle_y);
            } else {
                int offset_x = (-1 * element.getSize().getWidth());
                action.moveTo(offset_x, 0);

            }
            action.release();
            action.perform();
        } else {
            System.out.println("Method swipeElementToLeft() do nothing for platform" +Platform.getInstance().getPlatformVar());
        }
    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    private By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")){
         return By.xpath(locator);
        }else if(by_type.equals("id")){
            return By.id(locator);
        } else if(by_type.equals("css")){
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get typ of locator. Locator: " + locator_with_type);
        }
    }


    public void clickSkips(){
        this.waitElementAndClick(SKIP,"Cannot find and click skip button",10);
    }

}
