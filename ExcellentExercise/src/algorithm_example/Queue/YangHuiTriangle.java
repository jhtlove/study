package algorithm_example.Queue;

import java.util.Arrays;
import java.util.LinkedList;

import sort.Sort;

//打印
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class YangHuiTriangle
{
	//n次幂
	public static void yangvi(int n)
	{
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(1);
		int pre = 0,next = 0;
		int spaceNum = n - 1;
		for(int i=1;i<=n;i++)
		{
			for(int k=0;k<spaceNum;k++)
			{
				System.out.print(" ");
				
			}
			spaceNum--;
			q.add(0);
			for(int j=1;j<=i+2;j++)
			{
					
				next = q.remove(0);
				q.add((pre + next));
				pre = next;
				if(j != i+2)
				{
					System.out.print(next + " ");
				}
				else
				{
					System.out.println();
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		int i = 1; 测试位运算，没有循环移位符号
//		i = i << 31;//1会移动到符号位上
//		System.out.print(Integer.toBinaryString(i));
//		System.out.println(i);
//		System.out.print(Math.pow(2, 31));
		yangvi(6);
		
		
		//java.util 的 Arrays 带有很多静态方法，对数组进行操作，如排序、搜索等
//		int a[] = {2,7,9,10,1};
//		Sort.disArr(a);
//		Arrays.sort(a);
//		Sort.disArr(a);
	}

}
