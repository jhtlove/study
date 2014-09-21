package backtrace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NQueen1
{
	
	static int n;//皇后个数
	static int x[];//当前解；
	static int sum;//当前已找到的可行方案个数
	static ArrayList<String> arr = new ArrayList<String>();
	public static int nQueen(int nn)
	{
		n = nn;
		sum = 0;
		x = new int[n+1];
		for(int i=0;i<=n;i++)
		{
			x[i] = 0;
		}
		backtrack(1);
		return sum;
	}

	private static boolean place(int k)
	{
		for(int j=1;j<k;j++)
		{
			if(Math.abs(k-j)==Math.abs(x[j]-x[k])||x[j]==x[k])
			{
				return false;
			}
		}
		
		return true;
		
	}

	private static void backtrack(int t)
	{
		if(t>n)
		{
			sum++;
			StringBuffer strb = new StringBuffer();
			for(int i=1;i<=n;i++)
			{
				strb.append(x[i]);
				
			}
			arr.add(strb.toString());
		}
		else
		{
			for(int i=1;i<=n;i++)
			{
				x[t] = i;
				if(place(t))
				{
					backtrack(t+1);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		nQueen(8);
		Iterator<String>it = arr.iterator();
//		while(it.hasNext())
//		{
//			String s = it.next();
//			System.out.println(s);
//		}
		Scanner sca = new Scanner(System.in);
		int num = Integer.parseInt(sca.nextLine());
		if(num == 0)
		{
			sca.close();
			return;
		}
		else
		{
			int temp[] = new int[num];
			//int temp = 0;
			for(int i=0;i<num;i++)
			{
				temp[i] = Integer.parseInt(sca.nextLine());
				//temp = Integer.parseInt(sca.nextLine());
				if(temp[i] <1||temp[i] >92)
				{
					System.out.println();
				}
				else
				{
					System.out.println(arr.get(temp[i]-1));
				}
				
			}
			sca.close();
			for(int i=0;i<num;i++)
			{
				if(temp[i]<1||temp[i]>92)
				{
					System.out.println();
				}
				else
				{
					System.out.println(arr.get(temp[i]-1));
				}
				
			}
		}
		
	}

}
