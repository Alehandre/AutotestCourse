import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.net.URL;
import java.util.List;

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
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      } else {
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      }

      waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java","Cannot find search input",5); // В моей версии нет "Search..."
      waitForElementPresent(By.xpath("//*[@instance='2']//*[@text='Programming language']"),  //в моей версии отсутствует container
              "Cannot find 'Programming language' topic searching by 'Java'",
              10);
      waitForElementPresent(By.xpath("//*[contains(@text,'Island of Indonesia')]"),"Cannot find 'Island of Indonesia'",10);
      waitElementAndClick(By.id("org.wikipedia:id/search_close_btn"), "Not find element 'X'", 5);
      waitForElementNotPresent(By.id("org.wikipedia:id/search_close_btn"), "'X' is still present on the page",5);


  }

  @Test


  public void homeWorkEx4(){

      WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

      if (skip.isEnabled()) {
          skip.click();
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      } else {
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      }

      waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java","Cannot find search input",5);

      List<WebElement> elements = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));
      for (WebElement element : elements){
          if (element.
                  getText().
                  toLowerCase().
                  contains("java")) {
              System.out.println(element.getText());
          }
      }

  }

  @Test

  public void saveArticleEx5(){
      WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

      if (skip.isEnabled()) {
          skip.click();
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      } else {
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      }

      waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java","Cannot find search input",10);

      waitElementAndClick(By.xpath("//*[contains(@text,'Programming language')]"),
              "Cannot find 'Programming language Article'",
              5);

      waitElementAndClick(By.id("org.wikipedia:id/article_menu_bookmark"),
              "Cannot find button to open article options",
              5);

      WebElement gotIt = driver.findElementByXPath("//*[contains(@text,'GOT IT')]");

      if (gotIt.isEnabled()) {
          gotIt.click();
          waitElementAndClick(By.xpath("//*[contains(@text,'Create new')]"),
                  "Cannot find button 'Create new'",
                  5);
      } else {
          waitElementAndClick(By.xpath("//*[contains(@text,'Create new')]"),
                  "Cannot find button 'Create new'",
                  5);
      }

      String name_of_folder = "Learning programming";

      waitElementAndSendKey(By.id("org.wikipedia:id/text_input"),
              name_of_folder,
              "Cannot find search string input",
             5);

      waitElementAndClick(By.xpath("//*[@text='OK']"),
              "Cannot find 'OK' buttons",
              5);

      waitElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
              "Cannot find button to open Search Menu",
              5);

      waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
              "Java",
              "Cannot find search input",
              5);

      waitElementAndClick(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
              "Cannot find 'Island of Indonesia'",
              5);

      waitElementAndClick(By.id("org.wikipedia:id/page_actions_tab_layout"),
              "Cannot find 'Action tab'",
              5); // нужен для сброса информационной панели сбоку

      waitElementAndClick(By.id("org.wikipedia:id/article_menu_bookmark"),
              "Cannot find button to open article options",
              5);

      waitElementAndClick(By.xpath("//android.widget.TextView[@text='"+ name_of_folder +"']"),
              "Cannot find create list 'Learning programming'",
              5);

      waitElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
              "Cannot find button to open Main Menu",
      5);

      waitElementAndClick(By.xpath("//android.widget.Button[@text='NO THANKS']"),
              "Cannot find button 'NO THANKS'",
              5);

      waitElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
              "Cannot find button 'My lists'",
              5);

      waitElementAndClick(By.xpath("//android.widget.TextView[@text='GOT IT']"),
              "Cannot find button 'GOT IT'",
              5);

      waitElementAndClick(By.xpath("//android.widget.TextView[@text='Learning programming']"),
              "Cannot find button to open Create list",
              5);

      swipeElementToLeft(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
              "Cannot find create article");

      waitForElementNotPresent(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
              "Cannot delete saved article",
              10);

      waitElementAndClick(By.xpath("//*[@text='Programming language']"),
              "Cannot find 'Programming language'",
              5);

      waitForElementPresent(By.xpath("//android.view.View[@content-desc='JavaScript']"),
              "Cannot find title 'JavaScript'"); // пойдет как 6-ой урок?
  }


  @Test
  public void assertElementPresentEx6()
  {
      WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

      if (skip.isEnabled()) {
          skip.click();
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      } else {
          waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),"Not find element 'Search Wiki'",5);
      }

      String search_line = "Soundgarden discography";

      waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
              search_line,
              "Cannot find search input",
              10);

      waitElementAndClick(By.xpath("//android.widget.TextView[@text='Discography']"),
              "Cannot find article with text Discography",
              5);

      int amount_of_search_results = getAmountOfElements(By.xpath("//android.view.View[@content-desc='Soundgarden discography']"));
      Assert.assertTrue("We found need title", amount_of_search_results > 0);

  }


    private WebElement waitForElementPresent(By by, String error_message)
    {

        return waitForElementPresent(by,error_message,5);

    }

    private WebElement waitElementAndClick(By by,  String error_message, long timeoutInSeconds )
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitElementAndSendKey(By by, String value, String error_message, long timeoutInSeconds )
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(by, error_message,10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x,middle_y)
                .waitAction(150)
                .moveTo(left_x,middle_y)
                .release()
                .perform();
    }

    private int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

}