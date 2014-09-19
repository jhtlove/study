package basic_level;

import java.util.ArrayList;
import java.util.HashMap;

class Node
{
	int num = 0;
	char c = 'a';

	
	Node()
	{
		num = 0;
	}
	
	Node(int num,char c)
	{
		this.num = num;
		this.c = c;
	}
	
	Node(char c)
	{
		//���캯����new��ʱ���õ�����ôÿ�ζ����µĶ��󣬲�����������ʵ��ͳ���ظ��ַ�
		this.c = c;
		num = 1;
	}
}

public  class CharCount
{

	public static void sortArr(ArrayList<Node> arr)
	{
		Node res[] = new Node[arr.size()];
		for(int i=0;i<res.length;i++)
		{
			res[i] = new Node(arr.get(i).num,arr.get(i).c);
		}
		
		for(int i=0;i<res.length;i++)
		{
			System.out.println(res[i].c + " ����Ϊ " + res[i].num);
		}
		
		for(int i=0;i<res.length;i++)
		{
			boolean swaped = false;
			for(int j=0;j<res.length-i-1;j++)
			{
				if(res[j].num < res[j+1].num)
				{
					Node temp = new Node(res[j].num,res[j].c);
					res[j].c = res[j+1].c;
					res[j].num = res[j+1].c;
					res[j+1].c = temp.c;
					res[j+1].num = temp.num;
					swaped = true;
				}
				if(swaped == false)
					break;
			}
		}
		for(Node n:res)
		{
			System.out.println(n.c + " ����Ϊ " + n.num);
		}
	}
	
//	public static void countChar1(String s)
//	{
//		HashMap maps = new HashMap();
//		char cs[] = s.toCharArray();
//		for(char c :cs)
//		{
//			maps.put(c, 1);
//		}
//		System.out.println(maps.size());
//	}
	
	public static void countChar(String s)
	{
		//String ss = "aabbbc sse  +--    ";
		ArrayList<Node> nodes = new ArrayList<Node>();//Ԫ�ط���˳����Σ�add
		for(int i=0;i<s.length();i++)
		{
			Node n = new Node(s.charAt(i));
			boolean added = false;
			for(int j=0;j<nodes.size();j++)
			{
				Node temp = nodes.get(j);
				if(n.c == temp.c)
				{
					temp.num++;
					added = true;
				}
			}
			if(false == added)
			{
				nodes.add(n);
			}
		}
		for(int i=0;i<nodes.size();i++)
		{
			System.out.println(nodes.get(i).c + " ����Ϊ " + nodes.get(i).num);
		}
System.out.println();
		while(nodes.size() > 0)
		{
			int index = 0;
			int max = 0;
			for(int i=0;i<nodes.size();i++)
			{
				if(nodes.get(i).num > max)
				{
					max = nodes.get(i).num;
					index = i;
				}
			}
			System.out.print(nodes.get(index).c + "��" + nodes.get(index).num + "��   ");
			nodes.remove(index);
		}
		//sortArr(nodes);
	}
	
	
	public static void main(String[] args)
	{
		countChar("aabbbc sse  +--    ");
		//countChar1("aabbbc sse  +--    ");
	}

}
