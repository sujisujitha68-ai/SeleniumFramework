package web;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Web1 {
	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		System.out.println("the title is :" + driver.getTitle());
        System.out.println("the url is :" + driver.getCurrentUrl());
		//driver.findElement(By.cssSelector("[jsname='yZiJbe']"));
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
		driver.quit();
      
}
}

//driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);

