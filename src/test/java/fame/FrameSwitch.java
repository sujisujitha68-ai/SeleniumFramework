package fame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwitch {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.switchTo().frame("iframeResult");
	
	driver.switchTo().frame(0);
	
	WebElement value=driver.findElement(By.xpath("//h1[contains(text(),'This page is displayed')]"));
	System.out.println(value.getText());
	driver.switchTo().defaultContent();
	System.out.println("Done");
	driver.quit();
			
}
}
