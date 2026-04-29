package move;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Right {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://the-internet.herokuapp.com/context_menu");
	
	WebElement wi=driver.findElement(By.id("hot-spot"));
	Actions an=new Actions(driver);
	
	an.contextClick(wi).perform();
	System.out.println("hovered move to user1");
	
	String sn=driver.switchTo().alert().getText();
	System.out.println(sn);
	driver.switchTo().alert().accept();
	
	
	Thread.sleep(3000);
	
    driver.quit();
}
}
