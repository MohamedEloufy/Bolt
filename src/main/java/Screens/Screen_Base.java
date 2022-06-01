package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.time.Duration;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
*  This screen contains the most common functions that we need it
*  Also contains page factory that call appium driver in each page to working on it
*/

public class Screen_Base {

    AppiumDriver driver;

    public static final long WAIT=25;
    public TouchAction actions;


    public Screen_Base(AppiumDriver appiumDriver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
        driver=appiumDriver;
    }

    // This method wait until the element is visible
    public void waitForVisibilityOfElement(MobileElement element)
    {
        WebDriverWait wait =new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    // This method used to clear any text appear in any text box before writing data or to delete the entered data
    public void clear(MobileElement element)
    {
        waitForVisibilityOfElement(element);
        element.clear();
    }



    // This Method used to click on any element
    public void click(MobileElement element)
    {
        waitForVisibilityOfElement(element);
        element.click();
    }

    // This method used to enter text on any text box
    public void sendText(MobileElement element , String text)
    {
        waitForVisibilityOfElement(element);
        element.sendKeys(text);
    }

    // This method used to get any element attribute which we can assert on it
    public String getAttribute(MobileElement element,String attribute)
    {
        waitForVisibilityOfElement(element);
        return element.getAttribute(attribute);

    }

    // This method used to scroll to bottom
    public void scroll_bottom()
    {
        Dimension dim= driver.manage().window().getSize();
        int scrollStart=(int)(dim.getHeight()*0.8);
        int scrollEnd=(int)(dim.getHeight()*0.1);
        actions=new TouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();


    }

    // This method used to scroll to up
    public void scroll_up()
    {
        Dimension dim= driver.manage().window().getSize();
        int scrollStart=(int)(dim.getHeight()*0.01);
        int scrollEnd=(int)(dim.getHeight()*0.8);
        actions=new TouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();


    }


}
