package my.tankwar;

import java.awt.*;
import java.util.Random;

public class Wall
{
	TankWarFrame twf = null;
	private int x;
	private int y;
	
	private int width;
	private int height;
	private static Random r = new Random();//公共的，随机数产生器；
	public Wall(int x,int y,int w,int h,TankWarFrame f)
	{
		if(x + w > TankWarFrame.GAME_WIDTH)
		{
			w = TankWarFrame.GAME_WIDTH - x;
		}
		if(y + h > TankWarFrame.GAME_HEIGHT)
		{
			h = TankWarFrame.GAME_HEIGHT - y;
		}
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
		this.twf = f;
	}
	
	public Wall(int w,int h,TankWarFrame f)
	{
		this.x = r.nextInt(TankWarFrame.GAME_WIDTH - 100);
		this.y = r.nextInt(TankWarFrame.GAME_HEIGHT -100) + 50;
		if(x + w > TankWarFrame.GAME_WIDTH)
		{
			w = TankWarFrame.GAME_WIDTH - x;
		}
		if(y + h > TankWarFrame.GAME_HEIGHT)
		{
			h = TankWarFrame.GAME_HEIGHT - y;
		}
		this.height = h;
		this.width = w;
		this.twf = f;
		
	}
	
	public Rectangle getRec()
	{
		return new Rectangle(this.x,this.y,this.width,this.height);
	}
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(c);
	}
}
