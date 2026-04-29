package orange;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Macy {
	public static void main(String[] args) {
		

                  WebDriver driver=new ChromeDriver();
                  driver.manage().window().maximize();
                  driver.manage().deleteAllCookies();
                  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                  driver.get("https://www.macys.com/?from=signout");
                  System.out.println("the title is: " +driver.getTitle());
                  System.out.println("the current url is :"+ driver.getCurrentUrl());
                  
                  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
                  try {
                      WebElement closePopup = wait.until(
                          ExpectedConditions.elementToBeClickable(
                              By.xpath("//button[@name='bluecoreCloseButton']")
                          )
                      );
                      closePopup.click();
                      System.out.println("Popup closed");
                  } catch (TimeoutException e) {
                      System.out.println("Popup not present");
                  }

                  try {
                      wait.until(
                          ExpectedConditions.invisibilityOfElementLocated(
                              By.xpath("//div[contains(@class,'bluecoreOverlay')]")
                          )
                      );
                      System.out.println("Overlay disappeared");
                  } catch (TimeoutException e) {
                      System.out.println("Overlay not present");
                  }

                  WebElement signin=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign')]")));
                  signin.click();
                  System.out.println("sigin clickable");
                  
                  
                  WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
                  email.sendKeys("reachpradee@gmail.com");
                  WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwd")));
                  password.sendKeys("Mybank@28");
                  WebElement sign=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Sign In ']/..")));
                 
                  sign.click();
                  
                 /** wait.until(ExpectedConditions.urlContains("account"));
                  String currenturl=driver.getCurrentUrl();
                  
                  if(currenturl.contains("sale"))
                  {
                	  System.out.println("the page is loaded");
                  }
                  else
                  {
                	  System.out.println("the page is not loaded");
                  }*/
                  
                  try {
                      Thread.sleep(5000);
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  driver.quit();

}
}