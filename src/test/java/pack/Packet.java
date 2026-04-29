package pack;

import java.io.File;
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

public class Packet {
	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.sendKeys("Admin");
		WebElement password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("admin123");
		WebElement login= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		WebElement dashb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']/..")));
		System.out.println("After login:"+driver.getTitle());
		System.out.println("After url:"+driver.getCurrentUrl());
		System.out.println("Heading is"+dashb.getText());
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/dashboard.png");
        FileHandler.copy(src, dest);

        System.out.println("Screenshot saved successfully");
        
        driver.quit();

	
}
}