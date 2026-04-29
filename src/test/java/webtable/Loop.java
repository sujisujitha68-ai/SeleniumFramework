package webtable;




	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Loop{
	    public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	        driver.get("https://the-internet.herokuapp.com/tables");

	        List<WebElement> rows = driver.findElements(
	                By.xpath("//table[@id='table1']//tbody/tr")
	        );

	        List<WebElement> cols = driver.findElements(
	                By.xpath("//table[@id='table1']//tbody/tr[1]/td")
	        );

	        System.out.println("Total rows: " + rows.size());
	        System.out.println("Total columns: " + cols.size());

	        for (int i = 1; i <= rows.size(); i++) {

	            for (int j = 1; j <= cols.size(); j++) {

	                String data = driver.findElement(
	                        By.xpath("//table[@id='table1']//tbody/tr[" + i + "]/td[" + j + "]")
	                ).getText();

	                System.out.print(data + "   ");
	            }

	            System.out.println();
	        }

	        driver.quit();
	    }
	}

