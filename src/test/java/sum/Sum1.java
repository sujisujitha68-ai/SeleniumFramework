package sum;

public class Sum1 {

	int sum(int a, int b)
	{
		int c=a+b;
		return c;
	}
	 public static void main(String[] args) {
		
		 Sum1 su=new Sum1();
		int b= su.sum(10, 20);
		 System.out.println(b);
	}
}
