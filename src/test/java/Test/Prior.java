package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
//import static org.testng.AssertJUnit.assertEquals;
//import static org.testng.Assert.assertEquals;

import java.lang.foreign.ValueLayout.OfShort;
import java.time.Duration;

//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

public class Prior {
	
	WebDriver driver;
	WebDriverWait wait;

@BeforeMethod()
public void setup()

{
	 driver=new ChromeDriver();
	  wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@Test (priority = 1)
public void openwebpage()
{    
	//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	System.out.println(driver.getCurrentUrl());
	System.out.println("the title:"+ driver.getTitle());
	System.out.println();

}

@Test (priority = 2)
public void login()
{

	WebElement wi =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
	wi.sendKeys("Admin");
	WebElement password =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
	password.sendKeys("admin123");
	WebElement login =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']")));
	login.click();
	wait.until(ExpectedConditions.urlContains("dashboard"));

    String url1 = driver.getCurrentUrl();
    AssertJUnit.assertTrue(url1.contains("dashboard"));
}
	
	
		
	
@Test (priority = 3)
public void logintest()
{
	String title=driver.getTitle();
	AssertJUnit.assertEquals(title,"OrangeHRM");
}
@AfterMethod()

public void exit()throws InterruptedException
{
	Thread.sleep(3000);
	driver.quit();
	//System.out.println("the page successfully");
}

}
	



