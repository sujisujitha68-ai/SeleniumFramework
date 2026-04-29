package move;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Goog {
public static void main(String[] args) throws InterruptedException {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("https://www.google.com");

WebElement search = driver.findElement(By.name("q"));

Actions act = new Actions(driver);

act.click(search)
   .sendKeys("selenium")
   .sendKeys(Keys.ENTER)
   .perform();
}
}