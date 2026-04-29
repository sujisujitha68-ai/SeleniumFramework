package Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Read1 {
	public static void main(String[] args) throws Exception {
		FileInputStream fss=new FileInputStream("C:\\Users\\reach\\excel\\Book1.xlsx");
		XSSFWorkbook book1=new XSSFWorkbook(fss);
		XSSFSheet shee=book1.getSheetAt(0);
		int row=shee.getLastRowNum();
		
		for(int i=0;i<=row; i++)
		{
			XSSFRow ro=shee.getRow(i);
			
			String username=ro.getCell(0).toString();
			String password=ro.getCell(1).toString();
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			name.sendKeys(username);
			
			WebElement password1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			password1.sendKeys(password);
			
			WebElement click=driver.findElement(By.xpath("//button[@type='submit']"));
			click.click();
			System.out.println("the login page successfully automate");
			
			//WebElement vali=
			String currenturl=driver.getCurrentUrl();
			
			if(currenturl.contains("dashboard"))
			{
				System.out.println("Succefully login");
			}
			else
			{
				System.out.println("not login");
			}
			
			driver.quit();
		
	}
			book1.close();
			fss.close();
		}
}
		
		
		
		
		
		
	


