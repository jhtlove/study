package quesystem;

import java.util.concurrent.locks.*;

public class QueSystem
{
	private static int num  = 0;//�����и���
	private Node head = null,tail = null;//��ͷ�Ͷ�βָ��
	private static QueSystem que = new QueSystem();
	private static Lock qLock = new ReentrantLock();//reentrant ����������ָ���һ���߳��Ѿ��õ���һ��������ô�������ٴ��õ���
	
	public QueSystem()
	{
		head = tail = null;
		num = 0;
		//��ʼ��queʱ���ظ����ã�StackOverflowError
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

		//�ӿ�
		if(head == null)
			return false;
		//ֻ��һ��Ԫ��ʱ��ͷָ���βָ��ָ��ͬһ�����
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
	
System.out.println("���ӣ�Ŀǰ��" + num + "��");
		return true;
	}
	
	public  void  inQue()
	{
		Node temp = que.new Node();//��Ҫqueȥnew
		if(tail != null)
		{
			tail.next = temp;
			tail = temp;
		}
		else
		{
			//�ӿգ�tailֻ��һ��βָ�룬��û��ָ���κ�β��㣬ͷָ��headҲֻ��ָ��null
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
System.out.println("��ӣ�Ŀǰ��" + num + "��");
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
//System.out.println(null==null);true//����null	����ʹ��null.equals(null)������tem.equals(null);
//Node temp = new Node();//�����static���ڲ���Node�����Բ�new������QueSystemֱ��new Node
		Thread inque = new Thread(que.new InThread());
		Thread outque = new Thread(que.new OutThread());
		Thread inque2 = new Thread(que.new InThread());
		inque2.start();
		inque.start();
		outque.start();
	}
}
