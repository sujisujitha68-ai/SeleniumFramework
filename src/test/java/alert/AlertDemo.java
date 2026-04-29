package alert;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	
	 driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	 
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 
	 WebElement click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Click for JS')])[1]")));
	 click.click();
	 
	 Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		String text = alert1.getText();
		System.out.println(text);
		alert1.accept();
		
		WebElement get=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
		 
		String get1=get.getText();
		if(get1.equals("You successfully clicked an alert"))
		
		{
			System.out.println("pass");
	}
		
		else
			
		{
			System.out.println("fail");
		}
		
        //Thread.sleep(3000);
        
		//alert1.accept();
		
		WebElement click1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));
		 click1.click();
		 
		 Alert alert2=wait.until(ExpectedConditions.alertIsPresent());
		 String text2=alert2.getText();
		 System.out.println(text2);
		 alert2.accept();
		 //alert2.dismiss();
		 
		 //Thread.sleep(3000);
		 
			
			WebElement get11=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
			 
			String get2=get11.getText();
			if(get2.equals("You clicked: Ok"))
			
			{
				System.out.println("pass");
		}
			
			else
				
			{
				System.out.println("fail");
			}
			
		
        WebElement click2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']")));
		 click2.click();
		 
		 Alert alert3=wait.until(ExpectedConditions.alertIsPresent());
		 String text3=alert3.getText();
		 System.out.println(text3);
		 alert3.sendKeys("hello");
		 alert3.accept();
		 //alert2.dismiss();
		 
		 //Thread.sleep(3000);
		 
		 WebElement get111=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
		 
			String get3=get111.getText();
			if(get3.equals("You entered: hello"))
			
			{
				System.out.println("pass");
		}
			
			else
				
			{
				System.out.println("fail");
		
			}
	 
		 driver.quit();	
	}
}


/**alert.accept();     // click OK
alert.dismiss();    // click Cancel
alert.sendKeys("Hi"); // type text (only for prompt)
alert.getText();    // get message

*/