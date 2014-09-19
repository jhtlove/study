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
 * ����ֻΪ����main��������
 * @author zwj
 *
 */
public class TankWarClient
{
	//F1���¿�ʼ������������a�����ӵ���ctrl���ӵ���������ƶ�
	public static void main(String[] args)
	{
		new TankWarFrame().launchFrame();

	}
}

/**
 * ������̹�˴�ս��������
 * @author zwj
 *
 */

class TankWarFrame extends Frame
{
	/**
	 * ̹����Ϸ�ĸ߶�
	 */
	public static final int GAME_HEIGHT = 500;//����һ����public static final��
	/**
	 * ̹����Ϸ�Ŀ��
	 */
	public static final int GAME_WIDTH = 600;//�Ժ������Ҫ�ദ�ı��������Ϊ����
	
	private int level = 0;
	private int tankCount = 3;
	private boolean gameOver = false;
	Blood b = null;
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private Tank myTank = new Tank(100,300,true,this);
	ArrayList<Tank> tanks = new ArrayList<Tank>();
	private ArrayList<Missile> missiles = new ArrayList<Missile>();
	//Ŀǰ���Ϊ�������ڵ����ڴ�ܼ�һ�����������ÿ��̹�����Լ���һ���ڵ�
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
	 * ���������������������ϻ��Ƹ���ͼ��
	 */
	//���ĺ����������Ӧ���ڻ�����ʵ��
	public void paint(Graphics g)
	{
		b.draw(g);
		//g.drawString("missile count " + this.missiles.size(), 10, 40);
		g.drawString("�ؿ��� " + level,10,50);
		//Ȼ�󣬻���������
		//ÿ������Լ������Լ���draw����ȥ���Լ�
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
 				myTank.tankKeyPressed(e);//�м��˵����ã�����tankȥ���������
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
		new Thread(new PaintThread()).start();//�ڲ����ʹ��,newһ��Thread����ʵ����Runnable�ӿڵ��ڲ�����󴫵ݽ�ȥ
		//new Thread(new TankWarFrame().new PaintThread()).start();//����Ϊʲô���ԣ�
		//new PaintThread();//�Ǿ�̬����������ֱ��new�ڲ������
	}
	
	//�ڲ��࣬������ʰ�װ��ĳ�Ա�ͷ���
	private class PaintThread implements Runnable
	{
		//�̣߳���ʱ���������ػ�
		@Override
		public void run()
		{
			while(true)
			{
				repaint();//���õ�˭��repaint��  �ⲿ��װ��ģ����û�У��ⲿ�ڵĸ��࡭�����࡭��;repaint�����paint����
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





