package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver opa;
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";


@Override
    protected void setUp() throws Exception {

        super.setUp();
        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = this.getplatform(capabilities);

    }

@Override
    protected void tearDown() throws Exception{
    driver.quit();

    super.tearDown();
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {

        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "C:/Users/atregubov/Desktop/Java Appium Automation/apks/org.wikipedia.apk");

        } else if (platform.equals(PLATFORM_IOS)) {

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone SE");
            capabilities.setCapability("platformVersion", "11.4");
            capabilities.setCapability("app", "/Users/admin/Documents/GitHub/AutotestCourse/Ex8/apks/Wikipedia.app");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value" + platform);
        }

        return capabilities;
    }

    private AppiumDriver getplatform(DesiredCapabilities capabilities) throws Exception {
    String platform = System.getenv("PLATFORM");
        if (platform.equals(PLATFORM_ANDROID)) {
            opa = new AndroidDriver(new URL(AppiumURL), capabilities);
        }
        else if (platform.equals(PLATFORM_IOS)) {
            opa = new IOSDriver(new URL(AppiumURL), capabilities);
        }
        else {
            throw new Exception("Cannot get run platform from env variable. Platform value" + platform);
        }
        return opa;
    }

    }

