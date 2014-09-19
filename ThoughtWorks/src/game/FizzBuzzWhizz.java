package game;

/***
 * 
 * 1. ������˵��������ͬ����������Ҫ������Ǹ�λ��������3��5��7�� 2. ������ѧ���ĳ�һ�ӣ�Ȼ��˳������ 3.
 * ѧ������ʱ��������������ǵ�һ��������
 * ��3���ı�������ô����˵�����֣���Ҫ˵Fizz��������������ǵڶ�����������5���ı�������ôҪ˵Buzz��������������ǵ�����������
 * ��7���ı�������ôҪ˵Whizz�� 4.
 * ѧ������ʱ�������������ͬʱ�������������ı�������£�ҲҪ���⴦�������һ���������͵ڶ����������ı�������ô����˵�����֣�����Ҫ˵FizzBuzz,
 * �Դ����ơ����ͬʱ�������������ı�������ôҪ˵FizzBuzzWhizz�� 5.
 * ѧ������ʱ������������ְ����˵�һ������������ôҲ����˵�����֣�����Ҫ˵��Ӧ�ĵ���
 * �����籾���е�һ����������3����ôҪ��13��ͬѧӦ��˵Fizz����������а����˵�һ��������
 * ����ô���Թ���3�͹���4������Ҫ��35��ͬѧֻ��Fizz������BuzzWhizz��
 * 
 */
public class FizzBuzzWhizz
{
	private static int  a = 0, b = 5, c = 7;// 3����ͬ�ĸ�λ��������a<b<c,��һ����Ϊa

	// �ж�num�Ƿ����a
	public static boolean contains(int num, int a)
	{
		while (num > 0)
		{
			if (num % 10 == a)
			{
				return true;
			}
			num = num / 10;
		}
		return false;
	}
	//�ж�d�Ƿ�Ϊn������
	public static boolean isDivisor(int n,int d)
	{
		if(d == 0) return false;
		if(n % d == 0)return true;
		return false;
	}

	// n����ʱ��˵�Ļ�
	public static void say(int n)
	{
		System.out.print(n + " will say: ");
		if (contains(n, a))
		{
			System.out.println("Fizz");
			return;
		}
		boolean printed = false;
		if(isDivisor(n,a))
		{
			System.out.print("Fizz");
			printed = true;
		}
		if(isDivisor(n,b))
		{
			System.out.print("Buzz");
			printed = true;
		}	if(isDivisor(n,c))
		{
			System.out.print("Whizz");
			printed = true;
		}
		if (!printed)
		{
			System.out.print(n);
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		for (int i = 1; i <= 100; i++)
		{
			say(i);
		}
	}
}
