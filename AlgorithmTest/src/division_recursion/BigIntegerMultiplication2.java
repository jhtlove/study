package division_recursion;
/**
 * 把大整数分为多段计算？  不放入long,放入整形数组？或者 list里面？
 * 增强大整数乘法的可行性
 */
public class BigIntegerMultiplication2
{
	private static int a[] = {23,456,789,454,561};//表示23456789454561这个数，每3位分隔一下
	private static int b[] = {741,852,963,789,621};
	
	
	
	public static int[] getA()
	{
		return a;
	}

	public static void setA(int[] a)
	{
		BigIntegerMultiplication2.a = a;
	}

	public static int[] getB()
	{
		return b;
	}

	public static void setB(int[] b)
	{
		BigIntegerMultiplication2.b = b;
	}
	//统计规则的— —每3位一个逗号的数组
	public static int countRegular(int arr[])
	{
		if(arr == null) return 0;
		int num = 0;
		int temp = arr[0];
		while(temp != 0)
		{
			num++;
			temp = temp / 10;
		}
		num += 3 * (arr.length-1);
		return num;
	}
	
	public static int count(int n)
	{
		int num = 0;
		while(num != 0)
		{
			num++;
			n = n / 10;
		}
		return num;
	}
	
	public static int count(int arr[])
	{
		if(arr == null) return 0;
		int num = 0;
		for(int i:arr)
		{
			while(i != 0)
			{
				num++;
				i = i / 10;
			}
		}
		return num;
	}
	
	public static void multiply(int a[],int b[])
	{
		//记录各项系数，乘出来后，合并同类项，安装降幂放入数组中，每6位一分
		int coefficient[] = new int[a.length + b.length -2];
		int coe = 0;//本项系数
		int carry = 0;//进位
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				
				coe = a[a.length-i-1] * b[b.length-j-1] ;
				if(count(coe) == 5)
				{
					
				}
				coefficient[a.length + b.length - i - j - 2] = coe;
			}
		}
	}
	
	public static void main(String[] args)
	{
//System.out.println(count(b));
		System.out.println(b[0]);
System.out.println(countRegular(b));
		
	}

}
