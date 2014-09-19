package list_reverse;
//µ›πÈµƒƒÊ÷√¡¥±Ì

class Node
{
	int data = 0;
	Node next = null;
	Node()
	{
		 data = 0;
		 next = null;
	}
	
	Node(int data)
	{
		this.data = data;
	}
}

public class ListReverse
{
	
	public static Node reverseList(Node currentNode)
	{
		if(currentNode.next == null || currentNode == null)
			return currentNode;
		Node nextNode = currentNode.next;
		currentNode.next = null;
		Node tempNode = reverseList(nextNode);
		nextNode.next = currentNode;
		return tempNode;
		
	}
	
	
	public static void main(String args[])
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		Node t = n1;
		while(t != null)
		{
			System.out.print(t.data + "  ");
			t = t.next;
		}
		System.out.println();
		reverseList(n1);
		t = n3;
		while(t != null)
		{
			System.out.print(t.data + "  ");
			t = t.next;
		}
	}
}
