package my.tankwar;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 此类只为运行main（）函数
 * @author zwj
 *
 */
public class TankWarClient
{
	//F1重新开始或升级继续，a超级子弹，ctrl发子弹，方向键移动
	public static void main(String[] args)
	{
		new TankWarFrame().launchFrame();

	}
}

/**
 * 本类是坦克大战的主窗口
 * @author zwj
 *
 */

class TankWarFrame extends Frame
{
	/**
	 * 坦克游戏的高度
	 */
	public static final int GAME_HEIGHT = 500;//常量一般是public static final的
	/**
	 * 坦克游戏的宽度
	 */
	public static final int GAME_WIDTH = 600;//以后可能需要多处改变的量定义为常量
	
	private int level = 0;
	private int tankCount = 3;
	private boolean gameOver = false;
	Blood b = null;
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private Tank myTank = new Tank(100,300,true,this);
	ArrayList<Tank> tanks = new ArrayList<Tank>();
	private ArrayList<Missile> missiles = new ArrayList<Missile>();
	//目前设计为：所有炮弹属于大管家一起管理，而不是每个坦克有自己的一组炮弹
	ArrayList<Explode> explodes = new ArrayList<Explode>();
	public ArrayList<Missile> getMissiles()
	{
		return missiles;
	}

	public ArrayList<Wall> getWalls()
	{
		return walls;
	}

	/**
	 * 本方法是用来在主窗体上绘制各种图形
	 */
	//画的函数，最初，应该在画布上实现
	public void paint(Graphics g)
	{
		b.draw(g);
		//g.drawString("missile count " + this.missiles.size(), 10, 40);
		g.drawString("关卡： " + level,10,50);
		//然后，画布传画笔
		//每个事物，自己调用自己的draw方法去画自己
		for(int i=0;i<walls.size();i++)
		{
			walls.get(i).draw(g);;
		}
		for(int i=0;i<explodes.size();i++)
		{
			Explode e = explodes.get(i);
			e.draw(g);
		}
		//myTank.drawTank(g);
		for(int i=0;i<tanks.size();i++)
		{
			Tank t = tanks.get(i);
			t.drawTank(g);
		}
		
		if(!myTank.isLive())
		{
			gameOver = true;
			g.drawString("GAME OVER !", TankWarFrame.GAME_WIDTH/2, TankWarFrame.GAME_HEIGHT/2);
		}
		else if(tanks.size()==1)
		{
			gameOver = true;
			g.drawString("YOU WIN ! Level Up!", TankWarFrame.GAME_WIDTH/2, TankWarFrame.GAME_HEIGHT/2);
		}
		for(int i=0;i<this.getMissiles().size();i++)
		{
			Missile m = this.getMissiles().get(i);
			m.drawTankBullet(g);
		}
	}
	
	public void reStart()
	{
		if(myTank.isLive())
		{
			Properties p = new Properties();
			try
			{
				p.load(this.getClass().getClassLoader().getResourceAsStream("config/tank.properties"));
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tankCount = Integer.parseInt(p.getProperty("tankCount"));
			level ++;
		}
		else
		{
			tankCount = 5;
			level = 1;
		}
		tanks.clear();
		missiles.clear();
		walls.clear();
		myTank = new Tank(true,this);
		b = new Blood(this);
		tanks.add(myTank);
		for(int i=0;i<tankCount;i++)
		{
			tanks.add(new Tank(false,this));
		}
		walls.add(new Wall(20,200,this));
		walls.add(new Wall(200,20,this));
		this.gameOver = false;
	}
	
	public void launchFrame()
	{
		reStart();
		this.setBounds(100, 100, GAME_WIDTH, GAME_HEIGHT);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent arg0)
			{
				setVisible(false);
				System.exit(0);
			}
		});
		this.setBackground(new Color(0,150,0));
		this.addKeyListener(new KeyAdapter()
		{
//			@Override
//			public void keyTyped(KeyEvent e)
//			{
//				
//			}

			@Override
			public void keyPressed(KeyEvent e)
			{
 				myTank.tankKeyPressed(e);//中间人的作用，传给tank去做具体的事
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				int k = e.getKeyCode();
				if(k == KeyEvent.VK_F1 && gameOver)
				{
					reStart();
					
				}
				else if(k == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
				else
				{
					myTank.tankKeyReleased(e);
				}
				
			}
			
		});
		
		this.setVisible(true);
		new Thread(new PaintThread()).start();//内部类的使用,new一个Thread，把实现了Runnable接口的内部类对象传递进去
		//new Thread(new TankWarFrame().new PaintThread()).start();//这样为什么不对？
		//new PaintThread();//非静态方法，可以直接new内部类对象
	}
	
	//内部类，方便访问包装类的成员和方法
	private class PaintThread implements Runnable
	{
		//线程，计时器，不断重画
		@Override
		public void run()
		{
			while(true)
			{
				repaint();//调用的谁的repaint？  外部包装类的，如果没有，外部内的父类……父类……;repaint会调用paint方法
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}

	
	
}





