package my.demo;

public class P
{
	private String s = "Tom";
	public int age = 12;
	public void display(int num,String s)
	{
		System.out.println("display!");
	}
		
	public static void main(String[] args) throws ClassNotFoundException
	{
		System.out.println("main");
		Class.forName("my.demo.P");
	}

}
