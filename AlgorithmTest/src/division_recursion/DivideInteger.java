package division_recursion;
//有问题
public class DivideInteger
{
	public static final int max = 5;//最大划分数
    public static final int resouceInt = 5;//被分解的原数
	public static void divideInt(int n,int m,String s)
	{
		if(n<1 || m<1)
		{
			return;
		}
		//分解为全1相加,且当前被分解数为n才打印 ，为什么不需要了？
//		if(m == 1)
//		{
//			for(int i=0;i<m;i++)
//				System.out.print("1");
//		}
//System.out.println("(" + n + "," + m + ")");
//		if(n == resouceInt)
//		{
//		}
		if(m < n)
		{
			
			System.out.print(s + m + " + ");
			divideInt(n-m,m,s + m + " + ");//最大加数等于m的划分
			divideInt(n,m-1,s);//最大加数小于m的划分
			
		}
		if(m == n)
		{
			//if(m == DivideInteger.max)
			System.out.println(m + "  ;");//最大加数为n，那就输出 n=n
			divideInt(n,n-1,s);//新起一个divideInt 打印就有问题！需要包含之前的打印信息
		}
		if(m > n)
		{
			divideInt(n,n,s);
		}

	}
	
	public static void main(String[] args)
	{
		divideInt(DivideInteger.resouceInt,DivideInteger.max,"");

	}

}
