package quesystem;

import java.util.concurrent.locks.*;

public class QueSystem
{
	private static int num  = 0;//队列中个数
	private Node head = null,tail = null;//对头和队尾指针
	private static QueSystem que = new QueSystem();
	private static Lock qLock = new ReentrantLock();//reentrant ，可重入是指如果一个线程已经拿到过一把锁，那么它可以再次拿到锁
	
	public QueSystem()
	{
		head = tail = null;
		num = 0;
		//初始化que时，重复调用，StackOverflowError
//		if(que == null)
//			que = new QueSystem();
		
	}

	private  class Node
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
	

	public boolean outQue()
	{

		//队空
		if(head == null)
			return false;
		//只有一个元素时，头指针和尾指针指向同一个结点
		if(head.equals(tail))
		{
			head = head.next;
			tail = null;
		}
		else
			head = head.next;
	
		//Node temp = head;
		qLock.lock();
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			num--;
		}
		finally
		{
			qLock.unlock();
		}
	
System.out.println("出队，目前有" + num + "人");
		return true;
	}
	
	public  void  inQue()
	{
		Node temp = que.new Node();//需要que去new
		if(tail != null)
		{
			tail.next = temp;
			tail = temp;
		}
		else
		{
			//队空，tail只是一个尾指针，并没有指向任何尾结点，头指针head也只是指向null
			head = temp;
			tail = temp;
		}
		qLock.lock();
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			num++;
		}
		finally
		{
			qLock.unlock();
		}
System.out.println("入队，目前有" + num + "人");
	}
	
	 class InThread implements Runnable
	{
		 boolean b = true;
		public void run()
		{
			while(b)
			{
				inQue();
			}
			
		}
	}
	
	class OutThread implements Runnable
	{
		boolean b = true;
		public void run()
		{
			
			while(b)
			{
				outQue();
			}
		}
	}
	
	public static void main(String []args)
	{
//System.out.println(null==null);true//但是null	不能使用null.equals(null)，可以tem.equals(null);
//Node temp = new Node();//如果是static的内部类Node，可以不new父对象QueSystem直接new Node
		Thread inque = new Thread(que.new InThread());
		Thread outque = new Thread(que.new OutThread());
		Thread inque2 = new Thread(que.new InThread());
		inque2.start();
		inque.start();
		outque.start();
	}
}
