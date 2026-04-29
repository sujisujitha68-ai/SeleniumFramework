package orange;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--guest");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		driver.get("https://www.saucedemo.com/");
		System.out.println("the title :" + driver.getTitle());
		System.out.println("the url is :" + driver.getCurrentUrl());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement username = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		username.sendKeys("standard_user");

		WebElement password = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys("secret_sauce");

		WebElement login = wait.until(
				ExpectedConditions.elementToBeClickable(By.id("login-button")));
		login.click();

		wait.until(ExpectedConditions.urlContains("inventory"));

		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains("inventory")) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}

		WebElement dress = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@data-test='inventory-item-name']")));
		dress.click();

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}



