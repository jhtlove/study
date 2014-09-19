package test.thread;

public class TestSynchronized
{

	public static void main(String[] args)
	{
		//同一个对象r去创建线程，对对象r加锁
		MyRun3 r = new MyRun3();
		r.flag = 0;
		Thread t1 = new Thread(r);
		t1.start();
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//MyRun3 r1 = new MyRun3();
		r.flag = 1;
		Thread t2 = new Thread(r);

		t2.start();

	}

}

class MyRun3 implements Runnable
{
	public int flag ;
	public synchronized void m1()
	{
		System.out.println("hi");
		try
		{
			Thread.sleep(4000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("baby");
	}
	
	public synchronized void m2()
	{
		System.out.println("hello");
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("lady");
	}
	
	@Override
	public void run()
	{
		if(flag == 0)
		{
			m1();
		}
		else
		{
			m2();
		}
		
	}
}