package fame;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameOuter {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://the-internet.herokuapp.com/nested_frames");
	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.switchTo().frame("frame-top");
	
	driver.switchTo().frame("frame-middle");
	    
        WebElement ele=driver.findElement(By.id("content"));	
        ele.sendKeys("hello");
        System.out.println(ele.getText());
        driver.switchTo().defaultContent();
	
	
	
	//System.out.println("Done");
	driver.quit();
			
}
}






