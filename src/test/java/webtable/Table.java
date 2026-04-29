package webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://the-internet.herokuapp.com/tables");
		//
		//String value = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[1]/td[1]")).getText();
		/**String value = driver.findElement(
			    By.xpath("//table[@id='table1']//tbody/tr[1]/td[1]")
			).getText();

			System.out.println(value);
		
		List<WebElement> rows = driver.findElements(
			    By.xpath("//table[@id='table1']//tbody/tr")
			);

			System.out.println("Total rows: " + rows.size());
		List<WebElement> cols = driver.findElements(
			    By.xpath("//table[@id='table1']//tbody/tr[1]/td")
			);

			System.out.println("Total columns: " + cols.size());*/
		
		
		

		    
	
driver.quit();
	}
}
		
	