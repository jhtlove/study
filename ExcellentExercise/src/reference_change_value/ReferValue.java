package reference_change_value;

import java.util.ArrayList;

import org.junit.Test;

class Node
{
	int n;
	
	Node()
	{}
	
	Node(int n)
	{
		this.n = n;
	}
}

public class ReferValue
{
	static String ss = "kitty";
	static String sss = "sssss";//û��Ҫ��ʲô��������ȥ��
	
	@Test
	public  void testArr()
	{
	    int a[] = {1,2};
	    int temp = a[0];
	    a[0] = a[1];
	    a[1] = temp;
	    System.out.println("a[0] = " + a[0] + ",a[1] = " + a[1]);
	}
	
	public static void change(String str)
	{
		str = "world";
		ss = str;//ֱ���޸ĳ�Ա��������Ϊ����ֱ�ӷ��ʣ�������Ӧ�ã��ı����ڲ����������ڲ�����ȥ��ֵ����
	}
	
	
	public static void change(ArrayList<Integer> str)
	{
		str.set(0, new Integer(3));
		//ss = str;//ֱ���޸ĳ�Ա��������Ϊ����ֱ�ӷ��ʣ�������Ӧ�ã��ı����ڲ����������ڲ�����ȥ��ֵ����
	}
	
	public static void change(Integer str)
	{
		str = new Integer(8);
		//ss = str;//ֱ���޸ĳ�Ա��������Ϊ����ֱ�ӷ��ʣ�������Ӧ�ã��ı����ڲ����������ڲ�����ȥ��ֵ����
	}
	
	@Test
	public  void changeStringArr()
	{
		String s[] = {"hello","world"};
		String temp = s[0];
		s[0] = s[1];
		s[1] = temp;
		System.out.println(s[0] + " " + s[1]);//world hello  �����ɹ�
		
	}
	
	@Test
	public void changeRefNode()
	{
		Node nodes[] = new Node[2];
		nodes[0] = new Node(0);
		nodes[1] = new Node(1);
		Node temp = nodes[0];
		nodes[0] = nodes[1];
		nodes[1] = temp;
		System.out.println(nodes[0].n + " " + nodes[1].n);
		//��ӡ��1 2�������ɹ�
				
	}
	
	public static void main(String args[])
	{
	      int a[] = {1,2};
	      int b[] = {3,4};
	      int temp[] = a;
	      a = b;
	      b = temp;
	    for(int i=0;i<a.length;i++)
	    {
	      System.out.print("a[" + i + "]=" + a[i] + " ");
	    }
	    System.out.println();
	  for(int j=0;j<b.length;j++)
	  {
	      System.out.print("b[" + j + "]=" +b[j] + " ");
	  }
	}  
//	public static void main(String args[])
//	{
//		ArrayList<Integer> arrs = new ArrayList<Integer>();
//		arrs.add(new Integer(1));
//		
//		ReferValue r = new ReferValue();
//		
//		int arr[] = {1,2,3};
//		String s = "hello";
//		Calculate.change(arr);
//		change(r.ss);//ss����ı�
//		change(sss);
//		System.out.println(arr[1]);//����ᱻ�޸ģ��ַ������᣿
//		change(arrs);
//		change(arrs.get(0));
//		System.out.println(r.ss + "     " + sss + ":" + arrs.get(0));
//	}
}

class Calculate
{
	public static void change(int a[])
	{
		a[1] = 100;
	}
	
	public static void change1(String str)
	{
		str = "world";
	}
	
	
}
