package my.tankwar;

import java.awt.*;
import java.util.*;


public class Missile
{

	private int x,y;
	private Direction d ;
	private TankWarFrame twf = null;//大管家
	private boolean good ;

	public static final int XSPEED = 20;//静态参数，用  类名. 调用
	public static final int YSPEED = 20;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private boolean live = true;
	//为什么不能在本地持有Graphics g 再赋值过来？
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image imgs[] = null;
	private static Map<String,Image> missileImages = new HashMap<String,Image>();
	//静态代码块，构造函数之前执行，实现初始化
	static
	{
		imgs = new Image[]{
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileL.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileLU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileRU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileR.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileRD.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileD.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileLD.gif"))
		};
		
		missileImages.put("L", imgs[0]);
		missileImages.put("LU", imgs[1]);
		missileImages.put("U", imgs[2]);
		missileImages.put("RU", imgs[3]);
		missileImages.put("R", imgs[4]);
		missileImages.put("RD", imgs[5]);
		missileImages.put("D", imgs[6]);
		missileImages.put("LD", imgs[7]);
	}
	
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
//		Color c = g.getColor();
//		if(isGood())
//		{
//			g.setColor(Color.red);
//		}
//		else
//		{
//			g.setColor(Color.yellow);
//		}
//		g.fillOval(x, y, WIDTH, HEIGHT);
//		g.setColor(c);
		switch(d)
		{
			//case里面不用，也不能用Direction. 了 ？
			case L:
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x, y + Tank.HEIGHT/2);
				g.drawImage(missileImages.get("L"), x, y, null);
				break;
			case LU:
				g.drawImage(missileImages.get("LU"), x, y, null);
				break;
			case U:
				g.drawImage(missileImages.get("U"), x, y, null);
				break;
			case RU:
				g.drawImage(missileImages.get("RU"), x, y, null);
				break;
			case R:
				g.drawImage(missileImages.get("R"), x, y, null);
				break;
			case RD:
				g.drawImage(missileImages.get("RD"), x, y, null);
				break;
			case D:
				g.drawImage(missileImages.get("D"), x, y, null);
				break;
			case LD:
				g.drawImage(missileImages.get("LD"), x, y, null);
				break;
			case STOP://没按键，坦克没动，坐标不变
				break;
		}
		move();//动、画;子弹打出去就自己飞，所以   每颗炮弹不断被重画   不断地调用自己的move  ，很合适
	}
	
	public void move() 
	{
		if(x > TankWarFrame.GAME_WIDTH + Missile.WIDTH || x < 0 || y < 0 || y > TankWarFrame.GAME_HEIGHT + Missile.HEIGHT || hitTanks(twf.tanks) || hitWalls(twf.getWalls()))
		{
			live = false;
			//炮弹死了就立马移除，这样没有机会从ArrayList拿到死掉的炮弹
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
//System.out.println("向右飞！");
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
			case STOP:
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
	 * 单纯地判断子弹是否打击到某一指定的坦克t，如果打击到了，返回true，否则，返回false
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
	 * 该方法用来判断每颗子弹是否打到敌人，与所有的坦克都去判断一下，并且打中后会做相应的处理
	 * @param ts 子弹打击所有坦克的ArrayList集合
	 * @return打中了返回true，否则返回false
	 */
	public boolean hitTanks(ArrayList<Tank> ts)
	{
		//每一刻子弹，打击所有存在的敌军坦克
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
