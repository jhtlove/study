package division_recursion;
/**
 * �Ѵ�������Ϊ��μ��㣿  ������long,�����������飿���� list���棿
 * ��ǿ�������˷��Ŀ�����
 */
public class BigIntegerMultiplication2
{
	private static int a[] = {23,456,789,454,561};//��ʾ23456789454561�������ÿ3λ�ָ�һ��
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
	//ͳ�ƹ���ġ� ��ÿ3λһ�����ŵ�����
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
		//��¼����ϵ�����˳����󣬺ϲ�ͬ�����װ���ݷ��������У�ÿ6λһ��
		int coefficient[] = new int[a.length + b.length -2];
		int coe = 0;//����ϵ��
		int carry = 0;//��λ
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
