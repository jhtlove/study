package division_recursion;
//还是有问题
public class DivideInteger3
{

	public static void divide(int n)
	{
		if(n == 1)
		{
			System.out.println(1);
		}
		else
		{
			for(int i=1;i<n;i++)
			{
				System.out.print(i + "+");
				divide(n-i);
			}
		}
	}
	
	public static void main(String[] args)
	{
		divide(6);

	}

}
