package move;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://the-internet.herokuapp.com/hovers");
	
	WebElement wi=driver.findElement(By.xpath("//h5[text()='name: user1']/../.."));
	Actions an=new Actions(driver);
	
	an.moveToElement(wi).perform();
	System.out.println("hovered move to user1");
	Thread.sleep(3000);
    driver.close();
}
}
