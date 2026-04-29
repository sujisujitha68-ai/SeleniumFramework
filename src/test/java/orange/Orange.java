package orange;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//
		//boolean loginSuccess = false;
		

		WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.sendKeys("Admin");
		WebElement password1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password1.sendKeys("admin123");
		WebElement login= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
		WebElement dashboardText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']/..")));


        System.out.println("After login title: " + driver.getTitle());
        System.out.println("After login URL: " + driver.getCurrentUrl());
        System.out.println("Heading is: " + dashboardText.getText());

        /**try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
*/
		driver.quit();

	}

	}

//span[text()='Dashboard']
