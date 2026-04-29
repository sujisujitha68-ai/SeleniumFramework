package Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Read {
public static void main(String[] args) throws Exception {
	
	FileInputStream fis=new FileInputStream("C:\\Users\\reach\\excel\\Book1.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("Sheet1"); 
	
	String username1=sheet.getRow(1).getCell(0).getStringCellValue();
	String passwordvalue=sheet.getRow(1).getCell(1).getStringCellValue();
	workbook.close();
	fis.close();
	
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
	name.sendKeys(username1);
	
	WebElement password1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	password1.sendKeys(passwordvalue);
	
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

	Thread.sleep(3000);
	
	//System.out.println("the login page successfully automate");
	driver.quit();

}
}
