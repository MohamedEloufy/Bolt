package Tests.Test_Bases;

import Utilities.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test_Base {

    public static AppiumDriver<MobileElement> driver=null;


    // Set up capabilities by passing them as a parameter in testng runner to change it from testng runner and without changing code
    @BeforeSuite(description = "Google Map")
    @Parameters({"platformName","device","os_version","url"})
    @Severity(SeverityLevel.BLOCKER)
    public void Set_up(String platformName,String device,String version,String url) throws MalformedURLException {


        // passing the apk from apk folder inside the project

        File filePath = new File(System.getProperty("user.dir"));
        File appDir = new File(filePath, "/APKs");
        File app = new File(appDir, "GoogleMaps.apk");


        DesiredCapabilities caps=new DesiredCapabilities();

        caps.setCapability("platformName",platformName);
        caps.setCapability("device",device);
        caps.setCapability("os_version",version);
        caps.setCapability("app", app.getAbsolutePath());

        driver=new AppiumDriver<>(new URL(url),caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    // This Method take screenshot if there is any failure
    @AfterMethod
    public void Take_Screenshot(ITestResult results)
    {
        if (results.getStatus()==ITestResult.FAILURE)
        {
            System.out.println("fail......!");
            System.out.println("taking screenshot........");
            Helper.Capture_Screenshot_On_Failure(driver, results.getName());
        }

    }

    // This Method will close the app
    @AfterSuite
    public void close_App()
    {
        driver.closeApp();
        driver.quit();
    }
}
