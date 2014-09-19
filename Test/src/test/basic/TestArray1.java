package test.basic;

//数组循环左移一位
public class TestArray1
{
	public static void main(String[] args)
	{
		int a[] = { 0, 1, 2, 3, 4, 5 };
		for (int j = 0; j < a.length; j++)
		{
			System.out.print(a[j] + " ");
		}
		System.out.println();
		int b = a[0];
		for (int i = 0; i < a.length - 1; i++)
		{
			a[i] = a[i + 1];
		}
		a[a.length - 1] = b;
		for (int j = 0; j < a.length; j++)
		{
			System.out.print(a[j] + " ");
		}

	}

}
