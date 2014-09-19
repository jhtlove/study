package test.basic;

public class Test_Add_Add
{

	public static int f(int n)
	{
		System.out.println(n);
		return n;
	}

	public static void main(String[] args)
	{
		int i = 5;
		f(i++);//只能变量++
		System.out.println(i);
		f(++i);
		//f(++f(i));//不能返回值++，返回值不是变量了，只是一个值
		byte b = (byte)128;//127还行，128需要强制类型转换；
		System.out.println(b);//结果 -128 

	}

}
