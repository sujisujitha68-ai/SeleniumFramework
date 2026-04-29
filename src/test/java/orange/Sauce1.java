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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Sauce1 {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();//-->key,value pair
		prefs.put("credentials_enable_service", false);//use key , value
		prefs.put("profile.password_manager_enabled", false);//put()--add setting-- key-->setting name,value-->anything like--true,false,anything

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-save-password-bubble");//stop pop up//add -arguments(send command to Chrome)
		options.addArguments("--guest");//clean temporary browser
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
        System.out.println("the titile:"+driver.getTitle());
        System.out.println("the url is:"+driver.getCurrentUrl());
        
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");
        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("secret_sauce");
        WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        login.click();
        wait.until(ExpectedConditions.urlContains("inventory"));
        
        
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("inventory")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        
        WebElement dropdown=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@data-test='product-sort-container']")));
        
        Select s=new Select(dropdown);
        s.selectByVisibleText("Price (low to high)");
        
      
       
        
        WebElement Addtocart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Add to cart')])[6]")));
        Addtocart.click();
        
        WebElement cartbadge=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='shopping_cart_container']//span[@data-test='shopping-cart-badge']")));
        cartbadge.click();
        
        wait.until(ExpectedConditions.urlContains("cart.html"));
        String current=driver.getCurrentUrl();
        if(current.contains("cart.html"))
        {
        	System.out.println("login successful");
        
        }
        else
        {
        	System.out.println("login failed");
        }
        
        WebElement checkout =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']")));
        checkout.click();
        WebElement firstname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first-name']")));
        firstname.sendKeys("Suji");
        WebElement secondname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@id='last-name']")));
        secondname.sendKeys("Ravi");
        WebElement postalcode =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@id='postal-code']")));
        postalcode.sendKeys("60503");
        WebElement continues=wait.until(ExpectedConditions.elementToBeClickable(By.xpath( "//input[@data-test='continue']")));
        continues.click();
         
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
        System.out.println("Continue page successfully landed");
        WebElement finish=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Finish']" )));
        finish.click();
        WebElement thankyou =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your order!']")));
  
        if(thankyou.isDisplayed())
        		{
        	      System.out.println("Order placed successfully");
        		}
        else
        {
        	System.out.println("order failed");
        }
        WebElement home=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //button[@id='back-to-products']" )));
        home.click();
        
  
        
  
        //button(contains(text(),'Add to cart')])[6]
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        driver.quit();

	}
}