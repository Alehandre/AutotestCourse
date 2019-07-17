package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AutorizationPageObject extends MainPageObject{
    private static final String
    LOGIN_BUTTON ="xpath://body/div/a[text()='Log in']",
    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AutorizationPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void clickAuthButton(){
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 5);
        this.waitElementAndClick(LOGIN_BUTTON, "CANNOT FIND AND CLICK AUTH BUTTON", 5);
    }

    public void enterLoginData(String login, String password){
        this.waitElementAndSendKey(LOGIN_INPUT, login, "Cannot put login in field", 5);
        this.waitElementAndSendKey(PASSWORD_INPUT, password, "Cannot put password in field", 5);
    }

    public void submitForm(){
        this.waitElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit button",5);
    }

}
