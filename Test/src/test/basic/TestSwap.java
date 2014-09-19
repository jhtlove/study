package test.basic;

public class TestSwap
{
	//形参，拷贝，不会影响实参
	public static void swap(int a,int b)
	{
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void arrCopy(Integer a[],Integer b[])
	{
		Integer c[] = a;
		a = b;
		b = c;
//		for(int s : a)
//		{
//			p(s);
//		}
	}
	
	private static void p(Object s)
	{
		System.out.print(s + " ");
		
	}
	
	private static<T> void pn(T s[])
	{
		for(T a : s)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	private static void pn(Object s)
	{
		System.out.println(s);
		
	}

	
	public static void swap(String a,String b)
	{
		String temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args)
	{
//		int a = 3,b = 5;
//		System.out.println("a = " + a + " b = " + b);
//		swap(a,b);
//		System.out.println("a = " + a + " b = " + b);

//		String s1 = "abc";
//		String s2 = "def";
//		swap(s1,s2);
//		pn("s1:" + s1 + "  s2:" + s2);
		
		Integer a1[] = {1,2,3};
		Integer b1[] = {4,5,6};
		pn(a1);
		arrCopy(a1,b1);
		pn(a1);
	}

}
