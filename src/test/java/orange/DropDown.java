package orange;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //driver.get("https://the-internet.herokuapp.com/dropdown");

       // WebElement dropdown = driver.findElement(By.id("dropdown"));

        //Select sel = new Select(dropdown);
        //sel.selectByVisibleText("Option 1");
        driver.get("https://www.google.com");

        WebElement wait1=driver.findElement(By.name("q"));
        wait1.sendKeys("selenium");
        
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        
        WebElement suggestion=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='selenium']")));
        suggestion.click();
        System.out.println("i got output");
        
        try {
        	Thread.sleep(5000);
        }
        catch(Exception e)
        {}
        driver.quit();
    }
}





