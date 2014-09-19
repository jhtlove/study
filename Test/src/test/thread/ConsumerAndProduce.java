package test.thread;

class Dish
{
	private static int num = 0;
	private static Apple ap[] = new Apple[5];// 静态的，为类所有，才是为所有对象公有
	private static Dish dd = null;

	public static Dish getDish()
	{
		if (dd == null)
		{
			dd = new Dish();
		}
		return dd;// 单例模式；使得他们访问同一个盘子对象（每个类实例对应一把锁，每个 synchronized 方法都必须获得调用该方法的类实例的锁方能执行）
	}
//	synchronized 这种机制确保了同一时刻对于每一个类实例，
//	其所有声明为 synchronized 的成员函数中至多只有一个处于可执行状态
//	（因为至多只有一个能够获得该类实例对应的锁），
//	从而有效避免了类成员变量的访问冲突
//	（只要所有可能访问类成员变量的方法均被声明为 synchronized）。
	public synchronized void getAp(Thread c)
	{
		System.out.println("盘子里面现在剩下 " + num + " 个苹果");
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
			System.out.println("I am " + c.getName() + "吃掉  苹果"
					+ ap[--num].getId());
			// System.out.println("吃掉 苹果" + ap[--num].getId());
			this.notifyAll();
		}
	}

	// 盘子类，提供操作接口
	public synchronized void putAp(Thread p)
	{
		for (int i = 0; i < 9; i++)
		{
			while (Dish.getDish().isFull())// while 叫醒之后还会继续检查一遍
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
			System.out.println("I am " + p.getName() + "放入  苹果"
					+ ap[num++].getId());
			// System.out.println("放入 苹果");
			this.notifyAll();
		}
		System.out.println("放入后，盘子里面有 " + num + " 个苹果");
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
