package dynamic_planning;

public class Knapsack_0_1
{
	//v价值，w重量，c总的容量，m[i，j]表示背包容量为j（其实j为下标，容量为j+1更合适的感觉），可以选择物品为i-n时，0-1背包的最优值；
	//容量和物品数量两个变量，所以“二维递减”。for一个物品{for 容量从0到c}
	public static void knapsack(int v[],int w[],int c ,int m[][])
	{
		int n = w.length - 1;
		
		/* 
		 * 啰嗦一点的写法，逻辑上更容易理解；“初始化数组最下层”
		 * 
		if(w[n]>c)
		{
			for(int j=0;j<=c;j++)
			{
				m[n][j] = 0;
			}
		}
		else
		{
			for(int j=0;j<w[n];j++)
			{
				m[n][j] = 0;
			}
			for(int j=w[n];j<=c;j++)
			{
				m[n][j] = v[n];
			}
		}*/
		
		
		int jMax = Math.min(w[n]-1, c);
		//刚好放不下物品n的容量；j表示背包的容量
		for(int j=0;j<=jMax;j++)//这里的 等号   就和   w[n]-1    呼应
		{
			m[n][j] = 0;
		}
		
		//能放入物品n的容量；v的max必然v[n],背包从空到有物品n，当然最大值是这个。
		//w[n]>c，物品n放不下，这个循环不执行;这个循环执行的话，也和上一个for不重复，漂亮的实现！！
		for(int j=w[n];j<=c;j++)
		{
			m[n][j] = v[n];
		}
		
		
		//m[0 - n-1,c]就得了最优值；物品1其实是在位置0，重量为w[0]
		for(int i=n-1;i>=1;i--)
		{
			jMax = Math.min(w[i]-1, c);
			for(int j=0;j<=jMax;j++)
			{
				m[i][j] = m[i+1][j];
			}
			for(int j=w[i];j<=c;j++)
			{
				m[i][j] = Math.max(m[i+1][j], m[i+1][j-w[i]] + v[i]);
			}
		}
		
		/**
		 * 因为 m[0,c]就得了最优值，问题就得解；所以最后单独处理物品1，只考虑容量为c的时候，不再看容量j<c的值了
		 */
		m[0][c] = m[1][c];//初始化为不放入1，然后再修改
		if(c >= w[0])
		{
			m[0][c] = Math.max(m[1][c], m[1][c-w[0]] + v[0]);
		}
		
	}
	
	public static void traceback(int m[][],int w[],int c,int x[])
	{
		int n = w.length - 1;
		for(int i=0;i<=n-1;i++)
		{
			if(m[i][c] == m[i+1][c])
			{
				x[i] = 0;
			}
			else
			{
				x[i] = 1;
				c = c - w[i];
			}
			x[n] = (m[n][c] > 0)?1:0;//??x[n]没法从n 和  n+1的比较得出（越界了），最后一行只要它自己非0就在里面了。
		}
	}
	
	//重构
	public static void disArr(int a[][])
	{
		int i=0,j=0;
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j] + "    ");
			}
			System.out.println();
		}
	}
	
	public static void disArr(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args)
	{
		int v[] = {6,3,5,4,6};
		int w[] = {2,2,6,5,4};
		int c= 10;
		int m[][] = new int[w.length][c+1];//矩阵里面，背包容量从0到c ，c+1个？
		int x[] = new int[w.length];
		knapsack(v,w,c,m);
		disArr(m);
		traceback(m,w,c,x);
		disArr(x);
	}

}
