package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import page.PageClass;



public class LoginTest {
	

@Test
public void loginTest() {

    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    PageClass login = new PageClass(driver);

    login.enterusername("Admin");
    login.enterpassword("admin123");
    login.enterloginbutton();

    driver.quit();
}
}


