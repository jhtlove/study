package test.basic;
//约瑟夫环
public class Count3Quit1
{
	
	//int a = b = 2;//错误！不能连等；可以int a=2，b=2;
	
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
		Node temp = new Node(1);//非静态方法里面可以new内部类
		
		int index = 0;
		//int count = c;
		for(int i=0;i<arr.length;i++)
		{
			while(count > 0)//不能大于等于0？死循环
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
			//do … while(count != 0);//必须有分号
			count = 3;
		}
	}

	public static void main(String[] args)
	{
		//Node temp = new Node(0);//静态方法里面，必须有外部类实例instance（对象）,才能new内部类对象
		Node a1 = new Count3Quit1().new Node(1);//创建内部类对象；先有外部类再有内部类。语法比较别扭
		Node a2 = new Count3Quit1().new Node(2);
		Node a3 = new Count3Quit1().new Node(3);
		Node a4 = new Count3Quit1().new Node(4);
		Node a5 = new Count3Quit1().new Node(5);
		Node[] arr = {a1,a2,a3,a4,a5};
		new Count3Quit1().count(arr,3);

	}

}
