package pack;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Source {
public static void main(String[] args) throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://sauce-demo.myshopify.com/");
	System.out.println("Title :"+driver.getTitle());
	System.out.println("url:"+driver.getCurrentUrl());
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	
	WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.id("customer_login_link")));
	login.click();
	
	WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_email")));
	username.sendKeys("your-real-email@example.com");
	
	WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_password")));
	password.sendKeys("your-real-password");
	
	
	WebElement login1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[@value='Sign In']"))));
	login1.submit();
	
	wait.until(ExpectedConditions.urlContains("account"));
	System.out.println("After login URL: " + driver.getCurrentUrl());
	//wait.until(ExpectedConditions.urlContains("/login"));
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File dest = new File("screenshots/dashboard1.png");
    FileHandler.copy(src, dest);

    System.out.println("Screenshot saved successfully");
    
			
	try
	{
		Thread.sleep(5000);	
      }      catch (Exception e)
	{
	}
	
	driver.quit();
}
}
