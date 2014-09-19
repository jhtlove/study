package game;

/***
 * 
 * 1. 你首先说出三个不同的特殊数，要求必须是个位数，比如3、5、7。 2. 让所有学生拍成一队，然后按顺序报数。 3.
 * 学生报数时，如果所报数字是第一个特殊数
 * （3）的倍数，那么不能说该数字，而要说Fizz；如果所报数字是第二个特殊数（5）的倍数，那么要说Buzz；如果所报数字是第三个特殊数
 * （7）的倍数，那么要说Whizz。 4.
 * 学生报数时，如果所报数字同时是两个特殊数的倍数情况下，也要特殊处理，比如第一个特殊数和第二个特殊数的倍数，那么不能说该数字，而是要说FizzBuzz,
 * 以此类推。如果同时是三个特殊数的倍数，那么要说FizzBuzzWhizz。 5.
 * 学生报数时，如果所报数字包含了第一个特殊数，那么也不能说该数字，而是要说相应的单词
 * ，比如本例中第一个特殊数是3，那么要报13的同学应该说Fizz。如果数字中包含了第一个特殊数
 * ，那么忽略规则3和规则4，比如要报35的同学只报Fizz，不报BuzzWhizz。
 * 
 */
public class FizzBuzzWhizz
{
	private static int  a = 0, b = 5, c = 7;// 3个不同的个位特殊数，a<b<c,第一个数为a

	// 判断num是否包含a
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
	//判断d是否为n的因数
	public static boolean isDivisor(int n,int d)
	{
		if(d == 0) return false;
		if(n % d == 0)return true;
		return false;
	}

	// n报数时该说的话
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
