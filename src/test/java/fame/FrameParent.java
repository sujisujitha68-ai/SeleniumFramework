package fame;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameParent {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");
	
	System.out.println(driver.getCurrentUrl());//outer frame to inner frame
	System.out.println(driver.getTitle());
	
	driver.switchTo().frame("iframeResult");
	
	driver.switchTo().frame(0);
	
	WebElement value=driver.findElement(By.xpath("//h1[contains(text(),'This page is displayed')]"));
	System.out.println(value.getText());
	
	driver.switchTo().parentFrame();
	System.out.println("i came back to parent frame");
	driver.switchTo().frame(0);
	System.out.println("again i am back to inner ftrame");
	
	System.out.println("Done");
	driver.quit();
			
}
}




