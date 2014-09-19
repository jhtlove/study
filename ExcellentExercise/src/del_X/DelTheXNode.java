package del_X;

import java.util.Random;

class Node
{
	int data;
	Node next;
	Node()
	{
		data = 0;
		next = null;
	}
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}



public class DelTheXNode
{
	public static Node head = null;
	public static Random r = new Random();
	public static Node creatList(int len)
	{
		Node h = new Node(3);
		Node temp = h;
		for(int i=0;i<len-1;i++)
		{
			Node t = new Node(r.nextInt(len));
			temp.next = t;
			temp = temp.next;
		}
		return h;
	}
	
	public static void disList(Node h)
	{
		Node dis = h;
		while(dis!=null)
		{
			System.out.print(dis.data + " ");
			dis = dis.next;
		}
		System.out.println();
	}
	
	
//	c����ָ����ô�ÿ��ԣ�java����
//	public static void delX2(int x, Node head)
//	{
//		if(head == null)
//			return;
//		if(head.data == x)
//		{
//			//Node t = head;
//			//t.next = null;
//			head = head.next;//��ֵ
//			delX2(x,head.next);
//		}
//		else
//		{
//			delX2(x,head.next);
//		}
//	}
	
	public static void delX(int x)
	{
		if(head == null)
			return;
		
		if(head.data == x)
		{
			head = head.next;
			delX(x);
		}
		else
		{
			Node nextNode = head.next;//ͷ����x���жϺ��;
			
			while(nextNode != null && nextNode.data != x )
			{
				nextNode = nextNode.next;
			}
			if(nextNode != null)
			{
				nextNode.data = head.data;
				head = head.next;
				//Ϊ�˱��ֵݹ飬ÿ�ζ���head����ɨx�ģ�Ч�ʲ���
				delX(x);
			}
		}
		
		
		
		
		
		
	}
	
	public static void main(String arg[])
	{
		head = creatList(5);
		disList(head);
		delX(3);
		//delX2(3,head);
		disList(head);
	}
}
