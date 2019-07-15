package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;


public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;


@Override
    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.skipWelcomePageForIOSApp();
        this.skipWelcomePageForAndroidPage();


    }

@Override
    protected void tearDown() throws Exception{
    driver.quit();

    super.tearDown();
    }

    private void skipWelcomePageForIOSApp()
    {
        if(Platform.getInstance().isIos()){
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }


    private void skipWelcomePageForAndroidPage()
        {
            if(Platform.getInstance().isAndroid()){
                MainPageObject MainPageObject = new MainPageObject(driver);
                MainPageObject.clickSkips();
            }

    }


}

