package upload;



		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;

		public class Uploa {
		    public static void main(String[] args) {

		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();

		        driver.get("https://the-internet.herokuapp.com/upload");

		        // Step 1: Locate file input
		        driver.findElement(By.id("file-upload"))
		        
		        // Step 2: Send file path
		        .sendKeys("C:\\Users\\reach\\docu\\Hello World.txt");

		        // Step 3: Click upload button
		        driver.findElement(By.id("file-submit")).click();

		        System.out.println("File uploaded successfully");
		        driver.quit();
		    }
		
	}


