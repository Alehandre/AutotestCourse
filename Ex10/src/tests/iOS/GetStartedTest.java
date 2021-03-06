package tests.iOS;

import lib.CoreTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome(){

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForTitleNewWays();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddPreferredLanguagesLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataLink();
        WelcomePage.clickGetStartedButton();

    }


}
