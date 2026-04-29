package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider {
	
	private static final String True = null;
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String Url=driver.getCurrentUrl();
		if(Url.contains("login"))
				{
			AssertJUnit.assertTrue(Url.contains("login"));
			System.out.println("successfully");
				}
			else
			{
				System.out.println("not successfully");

				}

	}
	
	@DataProvider (name= "logindata")
	public Object[][] getdata() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\reach\\excel\\provide.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[rows][cols];
		
		for(int i=1;i<=rows;i++)
		{
			
			for(int j=0;j<cols;j++)
			{
				obj[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		workbook.close();
		fis.close();
		return obj;
	}

	@Test(dataProvider = "logindata")
	public void settingdata(String username,String password,String validation)
	{
		WebElement wi =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		wi.sendKeys(username);
		WebElement pass =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		pass.sendKeys(password);
		
		WebElement login =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']")));
		login.click();
		
		if(validation.equalsIgnoreCase("valid"))
		{
			AssertJUnit.assertTrue(driver.getCurrentUrl().contains("dashboard"));
			
		}
		else
		{
			AssertJUnit.assertFalse(driver.getCurrentUrl().contains("login"));
		}
		
		System.out.println(username + "|" + password + "|" + validation);
		
		
	/**	String Url=driver.getCurrentUrl();
		
		if(Url.contains("dashboard"))
		{
			System.out.println("login entered correctly");
		}
		else
		{
			System.out.println("the login page not entered successfully");
		}
	}*/
	}

	@AfterMethod
	public void close()
	{
	driver.quit();
}
}