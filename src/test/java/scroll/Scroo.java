package scroll;



	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Scroo {
	    public static void main(String[] args) throws InterruptedException {

	        // Step 1: Open browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Step 2: Open website
	        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

	        // Step 3: Create JavaScriptExecutor
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Step 4: Scroll down slowly
	        for (int i = 0; i < 5; i++) {
	            js.executeScript("window.scrollBy(0,500)");
	            Thread.sleep(1000); // wait to see scroll
	        }

	        // Step 5: Scroll to bottom
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	        Thread.sleep(2000);

	        // Step 6: Close browser
	        driver.quit();
	    }
	}

