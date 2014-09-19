package my.tankwar;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tank
{
	BloodBar bb = new BloodBar();
	public static final int fullLife = 100;
	private int tankLife = fullLife;
	private int x,y;
	private boolean good;
	private boolean live = true;
	private int oldX;
	private int oldY;
	
	private Direction d = Direction.STOP;
	private Direction ptDir = Direction.R;
	boolean bl=false,bu=false,br=false,bd=false;//��ͬ�����ж��ĸ���������������ˣ���Ϊ����̧�����ֱ�false
	
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	
	public static final int WIDTH = 30;//��ͼƬ�����߶ȳ�ʼ��
	
	public static final int HEIGHT = 30;
	private static Random r = new Random();//�����ģ��������������
	//private Missile tankMissile = null;
	
	private int steps = r.nextInt(15) + 1;//������Ĳ������ٸı䷽��
	private TankWarFrame twf = null;//��ܼҡ����жԷ�������
	
	private static Image imgs[] = null;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Map <String,Image> tankImages = new HashMap<String,Image>();
	static
	{
		imgs = new Image[]{
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankL.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankLU.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankU.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankRU.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankR.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankRD.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/tankD.gif")),
					tk.getImage(Tank.class.getClassLoader().getResource("images/TankLD.gif")),
						};
		tankImages.put("L", imgs[0]);
		tankImages.put("LU", imgs[1]);
		tankImages.put("U", imgs[2]);
		tankImages.put("RU", imgs[3]);
		tankImages.put("R", imgs[4]);
		tankImages.put("RD", imgs[5]);
		tankImages.put("D", imgs[6]);
		tankImages.put("LD", imgs[7]);
		//final int WIDTH = imgs[0].getWidth(null);
	}
	
	
	
	public Direction getD()
	{
		return d;
	}

	public void setD(Direction d)
	{
		this.d = d;
	}


	public boolean isLive()
	{
		return live;
	}
	

	public void setLive(boolean live)
	{
		this.live = live;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public boolean isGood()
	{
		return good;
	}

	public Tank()
	{
		x = 0;
		y = 0;
	}
	
	public Tank(int x,int y,boolean good ,TankWarFrame f)
	{
		this.x = x;
		this.oldX = x;
		this.oldY = y;
		this.y = y;
		this.good = good;
		this.twf = f;

	}
	
	public Tank(boolean good,TankWarFrame f)
	{
		this.good = good;
		this.twf = f;
		this.x = r.nextInt(TankWarFrame.GAME_WIDTH - Tank.WIDTH);
		this.y = r.nextInt(TankWarFrame.GAME_HEIGHT - Tank.HEIGHT - 20) + 20;
		while(this.hitWalls(twf.getWalls()) || this.meetTanks(twf.tanks))
		{
			this.x = r.nextInt(TankWarFrame.GAME_WIDTH - Tank.WIDTH);
			this.y = r.nextInt(TankWarFrame.GAME_HEIGHT - Tank.HEIGHT - 20) + 20;
		}
	}
	
	public Rectangle getRec()
	{
		return new Rectangle(x,y,Tank.WIDTH,Tank.HEIGHT);
	}
	
	public int getTankLife()
	{
		return tankLife;
	}

	public void setTankLife(int tankLife)
	{
		this.tankLife = tankLife;
	}

	public boolean hitWalls(ArrayList<Wall> w)
	{
		for(int i=0;i<w.size();i++)
		{
			if(this.getRec().intersects(w.get(i).getRec()))
			{
				return true;
			}
		}
		return false;
	}
	
	public void stay()
	{
		x = oldX;
		y = oldY;
	}
	
	public boolean meetTanks(ArrayList<Tank> t)
	{
		for(int i=0;i<t.size();i++)
		{
			if(this != t.get(i) && this.getRec().intersects(t.get(i).getRec()) && this.isLive() && t.get(i).isLive())
			{
				return true;
			}
		}
		return false;
	}
	
	public void move()
	{
		locateDirection();
		if(good)eat(twf.b);
		if(this.hitWalls(twf.getWalls()) || this.meetTanks(twf.tanks))
		{
			stay();
		}
		else
		{
			oldX = x;
			oldY = y;
		}

		switch(d)
		{
			//case���治�ã�Ҳ������Direction. �� ��
			case L:
				if(x >= XSPEED)
					x -= XSPEED;
				else
					x = 0;
				break;
			case LU:
				if(x >= XSPEED && y >= Tank.YSPEED+30)
				{
					x -= XSPEED;
					y -= YSPEED;
				}
				else if(x < Tank.XSPEED && y >= Tank.YSPEED+30)
				{
					x = 0;
					y -= YSPEED;
				}
				else if(x >= XSPEED && y < Tank.YSPEED+30)
				{
					x -= XSPEED;
					y = 30;
				}
				else
				{
					x = 0;
					y = 30;
				}
				break;
			case U:
				if(y >= Tank.YSPEED+30)
					y -= YSPEED;
				else
					y = 30;
				break;
			case RU:
				if(x <= TankWarFrame.GAME_WIDTH - Tank.XSPEED - Tank.WIDTH && y >= Tank.YSPEED+30)
				{
					x += XSPEED;
					y -= YSPEED;
				}
				else if(x > TankWarFrame.GAME_WIDTH - Tank.XSPEED - Tank.WIDTH && y >= Tank.YSPEED+30)
				{
					x = TankWarFrame.GAME_WIDTH-Tank.WIDTH;
					y -= Tank.YSPEED;
				}
				else if(x <= TankWarFrame.GAME_WIDTH - Tank.XSPEED - Tank.WIDTH &&y < Tank.YSPEED+30)
				{
					x += Tank.XSPEED;
					y = 30;
				}
				else
				{
					x = TankWarFrame.GAME_WIDTH-Tank.WIDTH;
					y = 30;
				}
				break;
			case R:
				if(x <= TankWarFrame.GAME_WIDTH - Tank.XSPEED - Tank.WIDTH)
					x += XSPEED;
				else
					x = TankWarFrame.GAME_WIDTH - Tank.WIDTH;
				break;
			case RD:
				if(x <= TankWarFrame.GAME_WIDTH - Tank.XSPEED - Tank.WIDTH && y <= TankWarFrame.GAME_HEIGHT - Tank.YSPEED - Tank.HEIGHT)
				{
					x += XSPEED;
					y += YSPEED;
				}
				else if(x > TankWarFrame.GAME_WIDTH-Tank.XSPEED - Tank.WIDTH && y <= TankWarFrame.GAME_HEIGHT - Tank.YSPEED - Tank.HEIGHT)
				{
					x = TankWarFrame.GAME_WIDTH - Tank.WIDTH;
					y += YSPEED;
				}
				else if(x <= TankWarFrame.GAME_WIDTH - Tank.XSPEED - Tank.WIDTH &&y > TankWarFrame.GAME_HEIGHT - Tank.YSPEED - Tank.HEIGHT)
				{
					x += Tank.XSPEED;
					y = TankWarFrame.GAME_HEIGHT - Tank.HEIGHT;
				}
				else
				{
					x = TankWarFrame.GAME_WIDTH - Tank.WIDTH;
					y = TankWarFrame.GAME_HEIGHT - Tank.HEIGHT;
				}
				break;
			case D:
				if(y <= TankWarFrame.GAME_HEIGHT - Tank.YSPEED - Tank.HEIGHT)
					y += YSPEED;
				else
					y = TankWarFrame.GAME_HEIGHT - Tank.HEIGHT;
				break;
			case LD:
				if(x >= Tank.XSPEED && y <= TankWarFrame.GAME_HEIGHT - Tank.YSPEED - Tank.HEIGHT)
				{
					x -= XSPEED;
					y += YSPEED;
				}
				else if(x < Tank.XSPEED && y <= TankWarFrame.GAME_HEIGHT - Tank.YSPEED - Tank.HEIGHT)
				{
					x = 0;
					y += Tank.YSPEED;
				}
				else if(x >= Tank.XSPEED && y > TankWarFrame.GAME_HEIGHT - Tank.HEIGHT - Tank.YSPEED)
				{
					x -= Tank.XSPEED;
					y = TankWarFrame.GAME_HEIGHT-Tank.HEIGHT;
				}
				else
				{
					x = 0;
					y = TankWarFrame.GAME_HEIGHT-Tank.HEIGHT;
				}
				break;
			case STOP://û������̹��û�������겻��
				break;
		}


		//�з���Ϳ��Զ�
		//������30�����Զ�һ��֮�������ж��Ƿ���磬��������ת��˼ά��ʽ����֮ǰ�жϣ����Ƹ��Ϻ��߼��������鷳�ܶࡣ
		
		
		if(!good)
		{
			steps--;
			if(steps <= 0)
			{
				Direction dd[] = Direction.values();//��ö��ת��Ϊ����
				int dn = r.nextInt(dd.length);//�������0��dd.length-1ֱ�ӵ�һ������
				d = dd[dn];//����ı䷽��
				steps = r.nextInt(15) + 1;
			}
			if(r.nextInt(40)>37)
			{
				fire();
			}
		}
	}
	
	public void drawTank(Graphics g)
	{
		if(!isLive())
		{
			twf.tanks.remove(this);
			return;
		}
		//Color c = g.getColor();
		if(this.isGood())
		{
			this.bb.draw(g);
			//g.setColor(Color.red);
			
		}
//		else
//		{
//			g.setColor(Color.blue);
//		}
//		g.fillOval(x, y, WIDTH, HEIGHT);//x y ������x,y�仯��,������̹��λ�þͱ䶯��
		//g.setColor(c);
	//	move();//Ϊʲô��move�ŵ�draw���棬�����ǰ����ĺ������棿����moveƵ�ʱ�ɹ̶�����
		//�����治��repaint��repaint����paint��paint����draw��draw�����move��ı�̹������
		//û����ʱ��Ҳ���ϵ���move��case �� STOP
		Color cc = g.getColor();
		g.setColor(Color.black);
		switch(ptDir)
		{
			//case���治�ã�Ҳ������Direction. �� ��
			case L:
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x, y + Tank.HEIGHT/2);
				g.drawImage(tankImages.get("L"), x, y, null);
				break;
			case LU:
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x, y);
				g.drawImage(tankImages.get("LU"), x, y, null);
				break;
			case U:
				g.drawImage(tankImages.get("U"), x, y, null);
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x + Tank.WIDTH/2, y);
				break;
			case RU:
				g.drawImage(tankImages.get("RU"), x, y, null);
			//	g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x + Tank.WIDTH, y);
				break;
			case R:
				g.drawImage(tankImages.get("R"), x, y, null);
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x + Tank.WIDTH, y + Tank.HEIGHT/2);
				break;
			case RD:
				g.drawImage(tankImages.get("RD"), x, y, null);
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x + Tank.WIDTH, y + Tank.HEIGHT);
				break;
			case D:
				g.drawImage(tankImages.get("D"), x, y, null);
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x + Tank.WIDTH/2, y + Tank.HEIGHT);
				break;
			case LD:
				g.drawImage(tankImages.get("LD"), x, y, null);
				//g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT /2, x, y + Tank.HEIGHT);
				break;
			case STOP://û������̹��û�������겻��
				break;
		}
		g.setColor(cc);
		move();
	}

	public void tankKeyPressed(KeyEvent e)
	{
		if(!isLive())return;
//System.out.println("key pressed");//����֤���Լ��������ˣ���ʵ�־����߼�
		int key = e.getKeyCode();

		switch(key)
		{
			case KeyEvent.VK_UP:
				bu = true;
				break;
			case KeyEvent.VK_RIGHT:
				br = true;
				break;
			case KeyEvent.VK_DOWN:
				bd = true;
				break;
			case KeyEvent.VK_LEFT:
				bl = true;
				break;
		}
		locateDirection();
		//move();
		//bl = bu = br = bd = false;//��������д �����ȡ�������ı䲻���ʣ�̹�˶϶����������ɿ������ٱ�
	}
	

	public void locateDirection()
	{
		if(good)
		{
			if(bl && !bu && !br && !bd) d = Direction.L;
			else if(bl && bu && !br && !bd) d = Direction.LU;
			else if(!bl && bu && !br && !bd) d = Direction.U;
			else if(!bl && bu && br && !bd) d = Direction.RU;
			else if(!bl && !bu && br && !bd) d = Direction.R;
			else if(!bl && !bu && br && bd) d = Direction.RD;
			else if(!bl && !bu && !br && bd) d = Direction.D;
			else if(bl && !bu && !br && bd ) d = Direction.LD;
			else if(!bl && !bu && !br && !bd) d = Direction.STOP;
		}
		if(this.d != Direction.STOP)
		{
			ptDir = d;
		}
	}

	public void tankKeyReleased(KeyEvent e)
	{
		if(!isLive())return;
		int key = e.getKeyCode();
//System.out.println("keycode" + key);
		switch(key)
		{
			case KeyEvent.VK_UP:
				bu = false;
				break;
			case KeyEvent.VK_RIGHT:
				br = false;
				break;
			case KeyEvent.VK_DOWN:
				bd = false;
				break;
			case KeyEvent.VK_LEFT:
				bl = false;
				break;
			case KeyEvent.VK_CONTROL:
				fire();
				break;
			case KeyEvent.VK_A:
				superFire();
				break;
//			case KeyEvent.VK_SPACE:
				//ͬʱ�������¼�������Ӧ�ո����
////System.out.println("fire!");
//				fire();
//				break;
		}
		locateDirection();
		//move();
	}
	
	public Missile fire()
	{
		if(!isLive()) return null;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.WIDTH / 2;
		//locateDirection();
//System.out.println("tank ����" + getD());
		Missile s = new Missile(x,y,this.isGood(),ptDir,this.twf);
		twf.getMissiles().add(s);
		return s;
	}
	
	//��������
	public void fire(Direction d)
	{
		if(!isLive()) return;
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.WIDTH / 2;
		//locateDirection();
//System.out.println("tank ����" + getD());
		Missile s = new Missile(x,y,this.isGood(),d,this.twf);
		twf.getMissiles().add(s);
	}
	
	public void superFire()
	{
		Direction d[] = Direction.values();
		for(int i=0;i<8;i++)
		{
			fire(d[i]);
		}
	}
	
	private class BloodBar
	{
	
		
		public void draw(Graphics g)
		{
			Color c = g.getColor();
			g.setColor(Color.black);
			g.drawRect(x, y-15, Tank.WIDTH, 10);
			g.setColor(Color.red);
			int w = tankLife * Tank.WIDTH / 100;
			g.fillRect(x, y-15,w, 10);
			g.setColor(c);
		}
	}
	
	public boolean eat(Blood b)
	{
		if(this.getRec().intersects(b.getRec()) && b.isLive() && this.isLive())
		{
			this.tankLife = Tank.fullLife;
			b.setLive(false);
			return true;
		}
		return false;
	}
	
}
