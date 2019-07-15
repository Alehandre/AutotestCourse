package lib.ui.android;


import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

   static {

       SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
               SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[contains(@text,'{SUBSTRING}')]";
               //FIND_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']";
               CLICK_RESULT = "id:org.wikipedia:id/search_close_btn";
               SEARCH_RESULT_ELEMENT = "xpath://android.view.View[@content-desc='Soundgarden discography']";
   }

    public AndroidSearchPageObject(AppiumDriver driver){
        super(driver);
    }


}
