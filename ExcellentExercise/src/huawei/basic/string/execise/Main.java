package huawei.basic.string.execise;

/**
 * 
 *华为oj所有代码都在Main类中测试
 *
 */

//import java.util.Scanner;
//
//public class Main
//{
//	public static void main(String args[])
//	{
//		
//		String s = null;
//		Scanner sca = new Scanner(System.in);
//		s = sca.nextLine();
//		String ss[] = s.split(" ");
//		int x[] = new int[3];
//		for(int i=0;i<ss.length;i++)
//		{
//			x[i] = Integer.parseInt(ss[i]);
//		}
//
//
//		
//		double a1 = x[0] / 1.0;
//		double a2 = x[1] / 2.0;
//		double a3 = x[2] / 3.0;
//		
//		double radius = 0.00000001;
//		
//		if(Math.abs(a1 - a2) <= radius && Math.abs(a2-a3) <= radius && Math.abs(a3 - a1) <= radius) 
//		{
//			System.out.println("YES " + (int)a1);
//		}
//		else
//		{
//			System.out.println("NO");
//		}
//		
//	}
//}

//import java.util.*;
//
//public class Main
//{
//	public static void main(String args[])
//	{
//		Scanner sca = new Scanner(System.in);
//		String s = sca.nextLine();
//		String ss[] = s.split(" ");
//		int a[] = new int[ss.length];
//		for(int i=0;i<ss.length;i++)
//		{
//			a[i] = Integer.parseInt(ss[i]);
//		}
//		System.out.print("const unsigned char buf[] = {");
//		
//		int j=0;
//		for(j=0;j<a[0]-1;j++)
//		{
//			String temp = Integer.toHexString(a[j+1]);
//			if(a[j+1] >=16)
//			{
//				System.out.print("0x" + temp + ",");
//			}
//			else
//			{
//				System.out.print("0x0" + temp + ",");
//			}
//		}
//		System.out.print("0x" + Integer.toHexString(a[j+1]));
//		System.out.print("};");
//	}
//}

import java.util.*;

public class Main
{
	public static void main(String args[])
	{
		Scanner sca = new Scanner(System.in);
		String s = sca.nextLine();
		sca.close();
		s = s.toLowerCase();
		char c;
		int sum = 0;
		if (s.charAt(0) == '0')
		{
			System.out.print(-1);
			return;
		}
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z')
			{
				switch (c)
				{
					case 'a':
						sum = sum * 16 + 10;
						break;
					case 'b':
						sum = sum * 16 + 11;
						break;
					case 'c':
						sum = sum * 16 + 12;
						break;
					case 'd':
						sum = sum * 16 + 13;
						break;
					case 'e':
						sum = sum * 16 + 14;
						break;
					case 'f':
						sum = sum * 16 + 15;
						break;
					default:
						sum = sum * 16 + (int) c - (int) '0';

				}
			}
			else
			{
				System.out.print(-1);
				return;
			}
		}
		System.out.print(Integer.toOctalString(sum));
	}
}