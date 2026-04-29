package locat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ixl.com/signin");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Username field = first visible text input
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[not(@type='hidden') and (not(@type) or @type='text')])[1]")));
        username.sendKeys("reyarithvin186");

        // Password field
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='password']")));
        password.sendKeys("ixl");

        // Sign in button
        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Sign in']")));
        signIn.click();

        Thread.sleep(10000);
        driver.quit();
    }
}