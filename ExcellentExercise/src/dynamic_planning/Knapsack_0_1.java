package dynamic_planning;

public class Knapsack_0_1
{
	//v��ֵ��w������c�ܵ�������m[i��j]��ʾ��������Ϊj����ʵjΪ�±꣬����Ϊj+1�����ʵĸо���������ѡ����ƷΪi-nʱ��0-1����������ֵ��
	//��������Ʒ�����������������ԡ���ά�ݼ�����forһ����Ʒ{for ������0��c}
	public static void knapsack(int v[],int w[],int c ,int m[][])
	{
		int n = w.length - 1;
		
		/* 
		 * ����һ���д�����߼��ϸ�������⣻����ʼ���������²㡱
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
		//�պ÷Ų�����Ʒn��������j��ʾ����������
		for(int j=0;j<=jMax;j++)//����� �Ⱥ�   �ͺ�   w[n]-1    ��Ӧ
		{
			m[n][j] = 0;
		}
		
		//�ܷ�����Ʒn��������v��max��Ȼv[n],�����ӿյ�����Ʒn����Ȼ���ֵ�������
		//w[n]>c����Ʒn�Ų��£����ѭ����ִ��;���ѭ��ִ�еĻ���Ҳ����һ��for���ظ���Ư����ʵ�֣���
		for(int j=w[n];j<=c;j++)
		{
			m[n][j] = v[n];
		}
		
		
		//m[0 - n-1,c]�͵�������ֵ����Ʒ1��ʵ����λ��0������Ϊw[0]
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
		 * ��Ϊ m[0,c]�͵�������ֵ������͵ý⣻������󵥶�������Ʒ1��ֻ��������Ϊc��ʱ�򣬲��ٿ�����j<c��ֵ��
		 */
		m[0][c] = m[1][c];//��ʼ��Ϊ������1��Ȼ�����޸�
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
			x[n] = (m[n][c] > 0)?1:0;//??x[n]û����n ��  n+1�ıȽϵó���Խ���ˣ������һ��ֻҪ���Լ���0���������ˡ�
		}
	}
	
	//�ع�
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
		int m[][] = new int[w.length][c+1];//�������棬����������0��c ��c+1����
		int x[] = new int[w.length];
		knapsack(v,w,c,m);
		disArr(m);
		traceback(m,w,c,x);
		disArr(x);
	}

}
