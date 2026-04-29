package move;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drop {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();

driver.get("https://the-internet.herokuapp.com/hovers");

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Step 1: Locate image
WebElement img = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img)[1]"))
);

// Step 2: Actions object
Actions act = new Actions(driver);

// Step 3: Hover
act.moveToElement(img).perform();

// Step 4: Now hidden element appears
WebElement profile = wait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='View profile'])[1]"))
);

// Step 5: Click
act.moveToElement(profile).click().perform();

System.out.println("Hover + Click Done");
}
}