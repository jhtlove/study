package test.thread;

class Dish
{
	private static int num = 0;
	private static Apple ap[] = new Apple[5];// ��̬�ģ�Ϊ�����У�����Ϊ���ж�����
	private static Dish dd = null;

	public static Dish getDish()
	{
		if (dd == null)
		{
			dd = new Dish();
		}
		return dd;// ����ģʽ��ʹ�����Ƿ���ͬһ�����Ӷ���ÿ����ʵ����Ӧһ������ÿ�� synchronized �����������õ��ø÷�������ʵ����������ִ�У�
	}
//	synchronized ���ֻ���ȷ����ͬһʱ�̶���ÿһ����ʵ����
//	����������Ϊ synchronized �ĳ�Ա����������ֻ��һ�����ڿ�ִ��״̬
//	����Ϊ����ֻ��һ���ܹ���ø���ʵ����Ӧ��������
//	�Ӷ���Ч���������Ա�����ķ��ʳ�ͻ
//	��ֻҪ���п��ܷ������Ա�����ķ�����������Ϊ synchronized����
	public synchronized void getAp(Thread c)
	{
		System.out.println("������������ʣ�� " + num + " ��ƻ��");
		for (int i = 0; i < 6; i++)
		{
			while (isEmpty())
			{
				try
				{
					this.wait();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("I am " + c.getName() + "�Ե�  ƻ��"
					+ ap[--num].getId());
			// System.out.println("�Ե� ƻ��" + ap[--num].getId());
			this.notifyAll();
		}
	}

	// �����࣬�ṩ�����ӿ�
	public synchronized void putAp(Thread p)
	{
		for (int i = 0; i < 9; i++)
		{
			while (Dish.getDish().isFull())// while ����֮�󻹻�������һ��
			{
				try
				{
					this.wait();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ap[num] = new Apple(num);
			System.out.println("I am " + p.getName() + "����  ƻ��"
					+ ap[num++].getId());
			// System.out.println("���� ƻ��");
			this.notifyAll();
		}
		System.out.println("��������������� " + num + " ��ƻ��");
	}

	public boolean isEmpty()
	{
		if (num == 0)
			return true;
		else
			return false;
	}

	public boolean isFull()
	{
		if (num == 5)
		{
			return true;
		} else
		{
			return false;
		}
	}
}

class Consumer implements Runnable
{
	public void run()
	{
		Dish.getDish().getAp(Thread.currentThread());
		System.out.println();
	}
}

class Producer implements Runnable
{
	public void run()
	{
		Dish.getDish().putAp(Thread.currentThread());
		System.out.println();
	}
}

class Apple
{
	private int id;

	Apple(int a)
	{
		setId(a);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}

public class ConsumerAndProduce
{

	public static void main(String[] args)
	{
		int i = 0;
		int a = 0;
		Consumer cc = new Consumer();
		Producer pp = new Producer();
		while (i < 3)
		{

			Thread c1 = new Thread(cc);
			c1.setName("c" + a++);
			Thread c2 = new Thread(cc);
			c2.setName("c" + a++);
			Thread c3 = new Thread(cc);
			c3.setName("c3");
			Thread p1 = new Thread(pp);
			p1.setName("p" + a++);
			Thread p2 = new Thread(pp);
			p2.setName("p" + a++);

			p1.start();
			p2.start();
			c1.start();
			c2.start();
			c3.start();
			i++;
		}
	}
}
