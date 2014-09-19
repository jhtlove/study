package testquestion;
//单链表上的加法，不过加法过程中完全没用到单链表……
public class AddInList
{
	Node head = new Node();
	
	public void disList()
	{
		Node t = head.next;
		while(t != null)
		{
			System.out.print(t.oneBit);
			t = t.next;
		}
		//System.out.println();
	}
	
	public Node initia(int num)
	{
		int temp = num;
		int n = 0;
		Node index = head;
		do
		{
			n = temp % 10;
			Node nod = new Node(n);
			nod.next = index.next;
			index.next = nod;
			temp = temp / 10;
		}while(temp != 0);
		return head.next;
	}
	
	public AddInList add(AddInList b)
	{
		Node index1 = head.next;
		Node index2 = b.head.next;
		int sum1 = 0;
		int sum2 = 0;
		while(index1 != null)
		{
			int oneBit1 = index1.oneBit;
			sum1 = oneBit1 + sum1 * 10;
			index1 = index1.next;
		}
//System.out.println(sum1);
		while(index2 != null)
		{
			int oneBit2 = index2.oneBit;
			sum2 = oneBit2 + sum2 * 10;
			index2 = index2.next;
		}
//System.out.println(sum2);
//开辟一个新的AddInList空间，不然就在原来的对象调用initia方法
		AddInList l = new AddInList();
		Node res = l.initia(sum1 + sum2);
		return l;
	}
	
	public static void main(String[] args)
	{
		AddInList adl = new AddInList();
		adl.initia(92);
		AddInList adl2 = new AddInList();
		adl2.initia(123);
		adl.disList();
		System.out.print(" + ");
		adl2.disList();
		System.out.print(" = ");
		adl.add(adl2).disList();
	}

}

class Node
{
	 int oneBit;
	 Node next;
	
	Node()
	{
		oneBit = 0;
		next = null;
	}
	
	Node(int oneBit)
	{
		if(oneBit >=0 && oneBit <=9)
			this.oneBit = oneBit;
		next = null;
	}
	
}
