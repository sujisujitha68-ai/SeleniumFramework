package sum;

public class Green {

	public BlueColor green()
	{
		System.out.println("The green color is likes blue color");
		return new BlueColor();
	}
	public static void main(String[] args) {
		Green g1=new Green();
		g1.green().blue().red1().purple1();
	}
}


