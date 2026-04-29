package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClass {

	WebDriver driver;
	
	public PageClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.name("username");
	By password=By.name("password");
	By loginbtn=By.xpath("//button[@type='submit']");


public void enterusername(String user)
{
	driver.findElement(username).sendKeys(user);
}
public void enterpassword(String pass)
{
	driver.findElement(password).sendKeys(pass);
}
	
	public void enterloginbutton()
	{
		driver.findElement(loginbtn).click();
	}
	
}
