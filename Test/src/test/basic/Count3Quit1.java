package test.basic;
//Լɪ��
public class Count3Quit1
{
	
	//int a = b = 2;//���󣡲������ȣ�����int a=2��b=2;
	
	private class Node
	{
		int date;
		boolean isIn ;
		
		Node(){}
		
		Node(int date)
		{
			this.date = date;
			isIn = true;
		}
	}
	
	public  void count(Node[] arr,int count)
	{
		Node temp = new Node(1);//�Ǿ�̬�����������new�ڲ���
		
		int index = 0;
		//int count = c;
		for(int i=0;i<arr.length;i++)
		{
			while(count > 0)//���ܴ��ڵ���0����ѭ��
			{
				if(arr[index].isIn == true)
				{
					count--;
				}
				if(count == 0)
				{
					System.out.print(arr[index].date + " ");
					arr[index].isIn = false;
				}
				index = ++index % arr.length;
			}
			//do �� while(count != 0);//�����зֺ�
			count = 3;
		}
	}

	public static void main(String[] args)
	{
		//Node temp = new Node(0);//��̬�������棬�������ⲿ��ʵ��instance������,����new�ڲ������
		Node a1 = new Count3Quit1().new Node(1);//�����ڲ�����������ⲿ�������ڲ��ࡣ�﷨�Ƚϱ�Ť
		Node a2 = new Count3Quit1().new Node(2);
		Node a3 = new Count3Quit1().new Node(3);
		Node a4 = new Count3Quit1().new Node(4);
		Node a5 = new Count3Quit1().new Node(5);
		Node[] arr = {a1,a2,a3,a4,a5};
		new Count3Quit1().count(arr,3);

	}

}
