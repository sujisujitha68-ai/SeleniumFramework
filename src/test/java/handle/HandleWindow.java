package handle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://the-internet.herokuapp.com/windows");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	String mainwindow= driver.getWindowHandle();
	
	WebElement cli=driver.findElement(By.xpath("//a[text()='Click Here']"));
	cli.click();
	
	Set<String> allwindows= driver.getWindowHandles();
	
	for(String win:allwindows)
	{
		if(!win.equals(allwindows));	
	    driver.switchTo().window(win);	
	}
	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.switchTo().window(mainwindow);
	System.out.println(driver.getCurrentUrl());
	driver.quit();
}
}
