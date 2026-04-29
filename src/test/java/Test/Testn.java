package Test;

	//import java.net.http.WebSocket;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Testn {

		@BeforeMethod
		public void setmethod()
		{
			System.out.println("setting the method");
		}
	    @Test
	    public void test()
	    {
	    	System.out.println("login test");
	    }
	   
	    @AfterMethod
	    public void aftermethod()
	    
	    {
	    	System.out.println("getting the method");
	    }
	    
	}

