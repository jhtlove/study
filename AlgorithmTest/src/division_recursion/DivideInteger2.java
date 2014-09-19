package division_recursion;

//递归、循环、累加;精巧的小程序！
public class DivideInteger2
{
	private static final int res = 4;

	public static void display(int n,String s)
	{
		//每次递归都从这里返回：把数全部分配完了，就打印；
//打印规律的话：先分出大的数，剩下部分的也先分出大的数；
//直接分完直接打印，没分完，下次循环一上来也必定立马分完；
//分出的数从尽可能大递减至1
		if(n == 0)
		{
			System.out.println(res + " = " + s.substring(3) + " ;");
		}
		else
		{
			//循环，使得分出去的数，遍历从它自身n到1的数；循环递归又循环的模式
			//在循环中，能保证递归回到相同的层次，某次的循环保持了n的一致性 
			for(int i=n;i>=1;i--)
			{
				//这样递减循环，可以使递归堆栈深度降低？
				display(n-i,s + " + " + i);//不断分出去一个i，每分出一个就累加分出去的i，记录好
			}
		}
			
	}
	
	public static void main(String[] args)
	{
		display(res,"");

	}

}
