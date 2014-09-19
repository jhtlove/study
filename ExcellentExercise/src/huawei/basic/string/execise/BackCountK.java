package huawei.basic.string.execise;

class Node
{
	int data;
	Node next;
	
	Node()
	{
		
	}
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

public class BackCountK
{
	public static void backCountK(int k,Node head)
	{
		Node index = head;//����ͷ���
		int len = 0;//������len  ������0   ����  ������   len - 1
		while(index != null)
		{
			index = index.next;
			len++;
		}
		
		if(k < 0 || k > len - 1)
		{
			System.out.println("������ " + k + " ��������");
			return;
		}
		int count = len - 1 - k;//�߽��飬��Ϊ��Ŀ���嵹����0����β�� ��
		index = head;
		while(count > 0)
		{
			index = index.next;
			count--;
		}
		System.out.println("������ " + k + " ��Ϊ�� " + index.data);
	}
	
	public static void main(String args[])
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		backCountK(3,n1);
	}
}
