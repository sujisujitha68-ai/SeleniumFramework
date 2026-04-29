package day02;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;


public class Fire {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://www.selenium.dev/");
        System.out.println("the title is :" + driver.getTitle());
        System.out.println("the url is :" + driver.getCurrentUrl());
        driver.close();
     	}
	
}
