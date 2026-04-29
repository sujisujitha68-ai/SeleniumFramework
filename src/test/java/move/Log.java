package move;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Log {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement username = driver.findElement(By.id("user-name"));
		//WebElement password = driver.findElement(By.id("password"));
                    Actions an=new Actions(driver);
                    an.click(username).sendKeys("standard_user").sendKeys(Keys.TAB).sendKeys("secret_sauce").sendKeys(Keys.ENTER).perform(); 
                    
                    //Thread.sleep(3000);
                    WebElement product = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

                    product.click();
                    Thread.sleep(3000);
                    
                    driver.quit();
  
	}

}
