package test.basic;

//数组模拟链表，怎么办？
public class TestArray2
{
	public static void disArray(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static int comDivisor(int a, int b)
	{
		int com = 1;
		for (int i = 1; i <= Math.min(a, b); i++)// <= 少个等号害死人
		{
			if (a % i == 0 && b % i == 0)
			{
				com = i;
			}
		}
		return com;
	}
	//把数组a，循环左移k位
	public static void leftMov(int a[], int k)
	{
		int x = k % a.length;// 左移位数
		int index = 0;// 移动前的位置
		// int index = 0;
		int temp = 0;// 移动元素
		int temp1 = 0;// 下一个移动元素
		if (comDivisor(a.length, x) == 1)// 互质，需判断
		{
			System.out.println("非循环的:");
			temp1 = a[index];// 下一个移动元素;为了第一次能顺利执行 temp=temp1;
			for (int i = 0; i < a.length; i++)
			{
				temp = temp1;
				index = (index - x + a.length) % a.length;// 被移后的位置
				temp1 = a[index];// 保存下一个被移动的元素
				a[index] = temp;// 目标位置放入被移动元素
			}
		} else
		{
			System.out.println("循环的:");
			temp1 = a[index];// 为了第一次能顺利执行 temp=temp1;
			int num = comDivisor(a.length, x);// 不互质，移动最大公约数次后就会产生循环
			for (int j = 0; j < a.length; j++)
			{
				temp = temp1;// 这一次移动的元素，是上一次被占位的元素
				if (num != 0)
				{
					// temp = a[index];//保存这次被移动的元素
					index = (index - x + a.length) % a.length;
					;
					temp1 = a[index];// 保存下一个被移动的元素
					a[index] = temp;// 目标位置放入被移动元素
				} else
				{
					// 只在num==0时执行一次，做各种初始化工作
					index++;
					index = index % a.length;// 谨慎
					num = comDivisor(a.length, x);// 计数“复位”
					temp = a[index];// 这次移动的元素，是新的开始，重新赋值，而不是上一次被占位的元素
					index = (index - x + a.length) % a.length;
					temp1 = a[index];
					a[index] = temp;
				}
				num--;
				// System.out.println("index=" + index);
			}
		}
	}

	public static void initArray(int a[])
	{
		for (int i = 0; i < a.length; i++)
		{
			a[i] = i + 1;
		}
	}

	public static void main(String[] args)
	{
		int a[] = new int[9];
		initArray(a);
		disArray(a);
		leftMov(a, 3);
		disArray(a);
		// for(int i=0;i<a.length;i++)
		// {
		// //取模k，则最大的数为k-1
		// a[i] = (i + 1) % a.length;//数组元素的值，表示下一个元素的位置
		// }
		// a[a[0]]

	}

}
