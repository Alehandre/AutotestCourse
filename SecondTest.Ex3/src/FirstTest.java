import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/atregubov/Desktop/Java Appium Automation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

  @Test
  public void HomeWork() {
      WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

      if (skip.isEnabled()) {
          skip.click();
          waitElementAndClick("//*[contains(@text,'Search Wikipedia')]","Not find element 'Search Wiki'",5);
      } else {
          waitElementAndClick("//*[contains(@text,'Search Wikipedia')]","Not find element 'Search Wiki'",5);
      }

      waitElementAndSendKey("//*[contains(@text,'Search Wikipedia')]", "Java","Cannot find search input",5); // В моей версии нет "Search..."
      waitForElementPresentByXpath("//*[@instance='2']//*[@text='Programming language']",  //в моей версии отсутствует container
              "Cannot find 'Programming language' topic searching by 'Java'",
              10);
      waitForElementPresentByXpath("//*[contains(@text,'Island of Indonesia')]","Cannot find 'Island of Indonesia'",10);
      waitElementAndClick("//*[@resource-id='org.wikipedia:id/search_close_btn']", "Not find element 'X'", 5);
      waitForElementNotPresent("org.wikipedia:id/search_close_btn", "'X' is still present on the page",5);


  }


    private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    private WebElement waitForElementPresentByXpath(String xpath, String error_message)
    {

        return waitForElementPresentByXpath(xpath,error_message,5);

    }

    private WebElement waitElementAndClick(String xpath,  String error_message, long timeoutInSeconds )
    {
        WebElement element = waitForElementPresentByXpath(xpath, error_message,timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitElementAndSendKey(String xpath, String value, String error_message, long timeoutInSeconds )
    {
        WebElement element = waitForElementPresentByXpath(xpath, error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(String id, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}