package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Method {
	@BeforeMethod()
	public void started()
	
	{
		System.out.println("hello");
	}
	
@Test(priority = 2)
 
public void testing()
{
	System.out.println("i got you");
}

@Test (priority = 1)
public void testing2()
{
	System.out.println("i pick you");
}
@AfterMethod()
public void end()
{
	System.out.println("bye");
}
}
