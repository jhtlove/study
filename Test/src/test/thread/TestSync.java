package test.thread;

public class TestSync
{
	public static void main(String[] args)
	{
		MyRun2 r = new MyRun2();
//		r.m2();
//		r.m1();
		Thread t = new Thread(r);
		t.start();
		r.m2();
		System.out.println("r.b = " + r.b);
	}

}

class MyRun2 implements Runnable
{
	int b = 10;
	
	public synchronized void m1()
	{
		System.out.println("m1 start");
		b = 40;//∑√Œ b
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("b = " + b);
	}
	
	public synchronized void m2()
	{
		System.out.println("m2 start");
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b = 30;
		System.out.println(b);
	}
	
	public void run()
	{
		m1();
	}
}
