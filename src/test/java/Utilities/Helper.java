package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Helper {
    public static void Capture_Screenshot_On_Failure(AppiumDriver<MobileElement> driver, String screenshotName)
    {
        Path destination= Paths.get("./Screenshots",screenshotName+".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream out=new FileOutputStream(destination.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screen shot"+e.getMessage());

        }
    }

}
