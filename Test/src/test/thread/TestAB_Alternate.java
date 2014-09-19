package test.thread;

public class TestAB_Alternate
{
	
	public static void main(String[] args)
	{
		MyRunnable r1 = new MyRunnable("张三");
		Thread A = new Thread(r1);
		MyRunnable r2 = new MyRunnable("李四");
		Thread B = new Thread(r2);
		
		B.start();//程序执行真正的先后start顺序，未必是按代码顺序执行，可能和编译器或者多核有关？
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
//				System.out.print("张三" + i + " ");
//			}
//		}
//		if(id == 2)
//		{
//			for(int i=0;i<10;i++)
//			{
//				System.out.print("李四" + i + " ");
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
	private  String info;//变量之前不能用synchronized
	
	private  String num = "1";//静态公共变量，控制同步；信号量
	
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
	//重写run()方法
	public void run()
	{
		String name = null;//不能private修饰？
		//因为局部变量之在方法中使用，方法执行完就没用了，所以即便是可以修饰也没有意义。
		boolean b = true;
		while(b)
		{
			//synchronized块，互斥变量num,信号量
			//synchronized加在while内部，不然while拿到信号量num，会死循环
			synchronized(num)
			{
				if("张三".equals(info))
				{
					System.out.println("张三start");
					name = "张三";
				}
					
				else
				{
					System.out.println("李四start");
					name = "李四";
				}
					
				//此处顺序与 A,B start顺序无关，并且创建了A，B两个线程，所以不存在连续来两个“李四”的情况
				//保证交替执行
				//“李四”来了先执行，执行完打印任务就等，叫醒等待队列上的线程
				//张三来了，先等
				//display放中间
				
				//张三打印完一次，再去排队，不让张三进程结束
				
		//并发开始后，被notify的进程，与当前并行的进程，实际执行先后顺序不确定；这也是并发特点，一旦start
				/*The awakened thread will compete in the usual manner with any other threads
				 *  that might be actively competing to synchronize on this object; 
				 *  for example, the awakened thread enjoys no reliable privilege 
				 *  or disadvantage in being the next thread to lock this object.*/
				if("张三".equals(info))
				{
					try
					{
						System.out.println("张三wait");
						num.wait();//Causes the current thread to wait
						
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("李四notify");//等待队列为空也没事
					num.notify();
					
				}
				
				display(info);
				System.out.println(name + " do something");
				
				if("李四".equals(info))
				{
					try
					{
						System.out.println("李四wait");
						num.wait();
						
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("张三notify");
					num.notify();
					
				}
			}
		}
	}
		
}
