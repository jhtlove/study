package test.basic;

public class TestQuMO
{
	public static int comDivisor(int a,int b)
	{
		int com = 1;
		for(int i=1;i<=Math.min(a, b);i++)
		{
			if(a % i == 0 && b % i == 0)
			{
				com = i;
			}
		}
		System.out.println(a + "和" + b + "的最大公约数：" + com);
		return com;
	}
	public static void main(String[] args)
	{
		System.out.println(6 % 3);
		System.out.println(comDivisor(9,3));
	}

}
