import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FirstTest extends CoreTestCase {

private MainPageObject MainPageObject;

protected void setUp() throws Exception
{
    super.setUp();
    MainPageObject = new MainPageObject(driver);
}

    @Test
    public void testSearch() {
        WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

        if (skip.isEnabled()) {
            skip.click();
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Not find element 'Search Wiki'", 5);
        } else {
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Not find element 'Search Wiki'", 5);
        }

        MainPageObject.waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "Cannot find search input", 5); // В моей версии нет "Search..."
        MainPageObject.waitForElementPresent(By.xpath("//*[@instance='2']//*[@text='Programming language']"),  //в моей версии отсутствует container
                "Cannot find 'Programming language' topic searching by 'Java'",
                10);

        MainPageObject.waitForElementPresent(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
                "Cannot find 'Island of Indonesia'",
                10);

        MainPageObject.waitElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
                "Not find element 'X'",
                5);

        MainPageObject.waitForElementNotPresent(By.id("org.wikipedia:id/search_close_btn"),
                "'X' is still present on the page",
                5);

    }



    @Test

    public void testSaveArticle() {
        WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

        if (skip.isEnabled()) {
            skip.click();
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Not find element 'Search Wiki'", 5);
        } else {
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Not find element 'Search Wiki'", 5);
        }

        MainPageObject.waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Java", "Cannot find search input", 10);

        MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Programming language')]"),
                "Cannot find 'Programming language Article'",
                5);

        MainPageObject.waitElementAndClick(By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to open article options",
                5);

        WebElement gotIt = driver.findElementByXPath("//*[contains(@text,'GOT IT')]");

        if (gotIt.isEnabled()) {
            gotIt.click();
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Create new')]"),
                    "Cannot find button 'Create new'",
                    5);
        } else {
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Create new')]"),
                    "Cannot find button 'Create new'",
                    5);
        }

        String name_of_folder = "Learning programming";

        MainPageObject.waitElementAndSendKey(By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot find search string input",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//*[@text='OK']"),
                "Cannot find 'OK' buttons",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find button to open Search Menu",
                5);

        MainPageObject.waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
                "Cannot find 'Island of Indonesia'",
                5);

        MainPageObject.waitElementAndClick(By.id("org.wikipedia:id/page_actions_tab_layout"),
                "Cannot find 'Action tab'",
                5); // нужен для сброса информационной панели сбоку

        MainPageObject.waitElementAndClick(By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to open article options",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.TextView[@text='" + name_of_folder + "']"),
                "Cannot find create list 'Learning programming'",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot find button to open Main Menu",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.Button[@text='NO THANKS']"),
                "Cannot find button 'NO THANKS'",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find button 'My lists'",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.TextView[@text='GOT IT']"),
                "Cannot find button 'GOT IT'",
                5);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.TextView[@text='Learning programming']"),
                "Cannot find button to open Create list",
                5);

        MainPageObject.swipeElementToLeft(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
                "Cannot find create article");

        MainPageObject.waitForElementNotPresent(By.xpath("//*[contains(@text,'Island of Indonesia')]"),
                "Cannot delete saved article",
                10);

        MainPageObject.waitElementAndClick(By.xpath("//*[@text='Programming language']"),
                "Cannot find 'Programming language'",
                5);

        MainPageObject.waitForElementPresent(By.xpath("//android.view.View[@content-desc='JavaScript']"),
                "Cannot find title 'JavaScript'"); // пойдет как 6-ой урок?
    }


    @Test
    public void testAssertElementPresent() {
        WebElement skip = driver.findElementByXPath("//*[contains(@text,'SKIP')]");

        if (skip.isEnabled()) {
            skip.click();
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Not find element 'Search Wiki'", 5);
        } else {
            MainPageObject.waitElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"), "Not find element 'Search Wiki'", 5);
        }

        String search_line = "Soundgarden discography";

        MainPageObject.waitElementAndSendKey(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot find search input",
                10);

        MainPageObject.waitElementAndClick(By.xpath("//android.widget.TextView[@text='Discography']"),
                "Cannot find article with text Discography",
                5);

        int amount_of_search_results = MainPageObject.getAmountOfElements(By.xpath("//android.view.View[@content-desc='Soundgarden discography']"));
        Assert.assertTrue("We found need title", amount_of_search_results > 0);

    }




}