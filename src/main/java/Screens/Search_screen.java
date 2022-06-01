package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Search_screen extends Screen_Base{
    public Search_screen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }



    // find element using @Android find by annotation
    @AndroidFindBy(id = "searchboxinput")
    public MobileElement search_text_box;

    @AndroidFindBy(id = "sbse28x0")
    public MobileElement first_result;

    @AndroidFindBy(className = "S9kvJb")
    public MobileElement direction_button;



    public void open_search_suggestion()
    {
        click(search_text_box);
    }
    public void enter_search_value(String search_value)
    {
        clear(search_text_box);
        sendText(search_text_box,search_value);
        click(first_result);

    }


}
