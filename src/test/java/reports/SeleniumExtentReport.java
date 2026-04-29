package reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumExtentReport {

    WebDriver driver;

    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setup() {

        // Step 1: Create HTML report file
        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/LoginReport.html");

        // Step 2: Create main report object
        extent = new ExtentReports();

        // Step 3: Attach HTML file to report
        extent.attachReporter(spark);

        // Step 4: Create test name in report
        test = extent.createTest("OrangeHRM Login Test");

        // Step 5: Open browser using Selenium
        driver = new ChromeDriver();
        test.pass("Chrome browser opened");

        driver.manage().window().maximize();
        test.pass("Browser maximized");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test.pass("OrangeHRM login page opened");
    }

    @Test
    public void loginTest() {

        driver.findElement(By.name("username")).sendKeys("Admin");
        test.pass("Username entered");

        driver.findElement(By.name("password")).sendKeys("admin123");
        test.pass("Password entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        test.pass("Login button clicked");

        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        test.pass("Login test completed");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
        test.pass("Browser closed");

        extent.flush();
    }
}