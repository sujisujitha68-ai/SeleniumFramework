package reports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentScreenshotDemo {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setup() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/LoginReport1.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        test = extent.createTest("OrangeHRM Login Test");

        driver = new ChromeDriver();
        test.pass("Chrome browser opened");

        driver.manage().window().maximize();
        test.pass("Browser maximized");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test.pass("OrangeHRM login page opened");
    }

    @Test
    public void loginTest() throws IOException, InterruptedException {

        driver.findElement(By.name("username")).sendKeys("Admin");
        test.pass("Username entered");

        driver.findElement(By.name("password")).sendKeys("admin123");
        test.pass("Password entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        test.pass("Login button clicked");

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("dashboard")) {
            test.pass("Login successful");
        } else {
            test.fail("Login failed because dashboard page not opened");

            String screenshotPath = takeScreenshot("LoginFailed");
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    public String takeScreenshot(String fileName) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = "reports/" + fileName + ".png";

        File dest = new File(path);

        FileHandler.copy(src, dest);

        return path;
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
        test.pass("Browser closed");

        extent.flush();
    }
}