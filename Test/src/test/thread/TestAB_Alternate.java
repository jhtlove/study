package test.thread;

public class TestAB_Alternate
{
	
	public static void main(String[] args)
	{
		MyRunnable r1 = new MyRunnable("����");
		Thread A = new Thread(r1);
		MyRunnable r2 = new MyRunnable("����");
		Thread B = new Thread(r2);
		
		B.start();//����ִ���������Ⱥ�start˳��δ���ǰ�����˳��ִ�У����ܺͱ��������߶���йأ�
		A.start();
		//System.out.println(A.getState());
		//System.out.println(A.isAlive());
		
	}

}
//
//class MyThread extends Thread
//{
//	private int id;
//	//private  static int num = 0;
//	
//	public MyThread(){}
//	
//	public MyThread(int id)
//	{
//		this.id = id;
//	}
//	
//	synchronized(this)
//	{
//		
//	}
	
//	public synchronized static void display(int id)
//	{
//		if(id == 1)
//		{
//			for(int i=0;i<10;i++)
//			{
//				System.out.print("����" + i + " ");
//			}
//		}
//		if(id == 2)
//		{
//			for(int i=0;i<10;i++)
//			{
//				System.out.print("����" + i + " ");
//			}
//		}
//	}
//	
//	public  void run()
//	{
//			display(id);
//	}
//}

class MyRunnable implements Runnable
{
	private  String info;//����֮ǰ������synchronized
	
	private  String num = "1";//��̬��������������ͬ�����ź���
	
	MyRunnable(){}
	
	MyRunnable(String info)
	{
		this.info = info;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public static void display(String info)
	{
		for(int i=0;i<10;i++)
		{
			System.out.print(info + i + " ");
		}
		System.out.println();
	}
	//��дrun()����
	public void run()
	{
		String name = null;//����private���Σ�
		//��Ϊ�ֲ�����֮�ڷ�����ʹ�ã�����ִ�����û���ˣ����Լ����ǿ�������Ҳû�����塣
		boolean b = true;
		while(b)
		{
			//synchronized�飬�������num,�ź���
			//synchronized����while�ڲ�����Ȼwhile�õ��ź���num������ѭ��
			synchronized(num)
			{
				if("����".equals(info))
				{
					System.out.println("����start");
					name = "����";
				}
					
				else
				{
					System.out.println("����start");
					name = "����";
				}
					
				//�˴�˳���� A,B start˳���޹أ����Ҵ�����A��B�����̣߳����Բ��������������������ġ������
				//��֤����ִ��
				//�����ġ�������ִ�У�ִ�����ӡ����͵ȣ����ѵȴ������ϵ��߳�
				//�������ˣ��ȵ�
				//display���м�
				
				//������ӡ��һ�Σ���ȥ�Ŷӣ������������̽���
				
		//������ʼ�󣬱�notify�Ľ��̣��뵱ǰ���еĽ��̣�ʵ��ִ���Ⱥ�˳��ȷ������Ҳ�ǲ����ص㣬һ��start
				/*The awakened thread will compete in the usual manner with any other threads
				 *  that might be actively competing to synchronize on this object; 
				 *  for example, the awakened thread enjoys no reliable privilege 
				 *  or disadvantage in being the next thread to lock this object.*/
				if("����".equals(info))
				{
					try
					{
						System.out.println("����wait");
						num.wait();//Causes the current thread to wait
						
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("����notify");//�ȴ�����Ϊ��Ҳû��
					num.notify();
					
				}
				
				display(info);
				System.out.println(name + " do something");
				
				if("����".equals(info))
				{
					try
					{
						System.out.println("����wait");
						num.wait();
						
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("����notify");
					num.notify();
					
				}
			}
		}
	}
		
}
