package my.tankwar;

import java.awt.*;
import java.util.*;

import my.tankwar.Tank.Direction;

public class Missile
{

	private int x,y;
	private Direction d ;
	private TankWarFrame twf = null;//��ܼ�
	private boolean good ;

	public static final int XSPEED = 20;//��̬��������  ����. ����
	public static final int YSPEED = 20;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private boolean live = true;
	//Ϊʲô�����ڱ��س���Graphics g �ٸ�ֵ������
	
	public Missile(int x,int y,boolean good,Direction d,TankWarFrame f)
	{
		this.x = x;
		this.y = y;
		this.good = good;
		this.d = d;
		this.twf = f;
	}
	
	public boolean isGood()
	{
		return good;
	}
	
	public void drawTankBullet(Graphics g)
	{
		if(!isLive())
		{
			return;
		}
		Color c = g.getColor();
		if(isGood())
		{
			g.setColor(Color.red);
		}
		else
		{
			g.setColor(Color.yellow);
		}
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();//������;�ӵ����ȥ���Լ��ɣ�����   ÿ���ڵ����ϱ��ػ�   ���ϵص����Լ���move  ���ܺ���
	}
	
	public void move() 
	{
		if(x > TankWarFrame.GAME_WIDTH + Missile.WIDTH || x < 0 || y < 0 || y > TankWarFrame.GAME_HEIGHT + Missile.HEIGHT || hitTanks(twf.tanks) || hitWalls(twf.getWalls()))
		{
			live = false;
			//�ڵ����˾������Ƴ�������û�л����ArrayList�õ��������ڵ�
			twf.getMissiles().remove(this);
		}
		switch(d)
		{
			case L:
				x -= XSPEED;
				break;
			case LU:
				x -= XSPEED;
				y -= YSPEED;
				break;
			case U:
				y -= YSPEED;
				break;
			case RU:
				x += XSPEED;
				y -= YSPEED;
				break;
			case R:
				x += XSPEED;
//System.out.println("���ҷɣ�");
				break;
			case RD:
				x += XSPEED;
				y += YSPEED;
				break;
			case D:
				y += YSPEED;
				break;
			case LD:
				x -= XSPEED;
				y += YSPEED;
				break;
		}

	}
	
	public boolean isLive()
	{
		return live;
	}

	public Rectangle getRec()
	{
		return new Rectangle(x,y,Missile.WIDTH,Missile.HEIGHT);
	}
	
	/*
	 * �������ж��ӵ��Ƿ�����ĳһָ����̹��t�����������ˣ�����true�����򣬷���false
	 */
	public boolean hitTank(Tank t)
	{

		if(this.getRec().intersects(t.getRec())&& t.isLive() && this.isLive())
		{
			return true;
		}
		return false;
	}
	
	public boolean hitWalls(ArrayList<Wall> w)
	{
		for(int i=0;i<twf.getWalls().size();i++)
		{
			if(this.isLive() && this.getRec().intersects(twf.getWalls().get(i).getRec()))
			{
				this.live = false;
				twf.getMissiles().remove(this);
				return true;
			}
		}
		
		return false;
	}
	/**
	 * �÷��������ж�ÿ���ӵ��Ƿ�򵽵��ˣ������е�̹�˶�ȥ�ж�һ�£����Ҵ��к������Ӧ�Ĵ���
	 * @param ts �ӵ��������̹�˵�ArrayList����
	 * @return�����˷���true�����򷵻�false
	 */
	public boolean hitTanks(ArrayList<Tank> ts)
	{
		//ÿһ���ӵ���������д��ڵĵо�̹��
		for(int i=0;i< ts.size();i++)
		{
			Tank t = ts.get(i);
			if(this.hitTank(t)&& this.good != t.isGood())
			{
				if(t.isGood())
				{
					t.setTankLife(t.getTankLife() - 20);
					if(t.getTankLife() <= 0)
					{
						t.setLive(false);
						twf.tanks.remove(t);
					}
				}
				else
				{
					t.setLive(false);
					twf.tanks.remove(t);
				}
				this.live = false;
				twf.getMissiles().remove(this);
				Explode e = new Explode(t.getX(),t.getY(),twf);
				twf.explodes.add(e);
			}
		}
		return false;
	}
	
	
	
	
}
