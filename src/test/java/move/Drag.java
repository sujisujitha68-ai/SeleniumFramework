package move;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
driver.get("https://the-internet.herokuapp.com/drag_and_drop");

WebElement source = driver.findElement(By.id("column-a"));
WebElement target = driver.findElement(By.id("column-b"));

Actions act = new Actions(driver);

//act.dragAndDrop(source, target).perform();

act.clickAndHold(source)
   .moveToElement(target)
   .release()
   .perform();

System.out.println("Drag and Drop done");
Thread.sleep(3000);

driver.quit();

}
}
