package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.BaseClass;

public class ScreenShotUtil {

    public static void takeScreenshot(String testName) throws IOException {

        File src = ((TakesScreenshot) BaseClass.driver)
                .getScreenshotAs(OutputType.FILE);

        File dest = new File("screenshots/" + testName + ".png");

        FileHandler.copy(src, dest);

        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
    }
}