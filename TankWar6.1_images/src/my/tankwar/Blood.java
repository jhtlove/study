package my.tankwar;

import java.awt.*;
import java.util.Random;

public class Blood
{
	int x,y;
	int value;
	TankWarFrame twf ;
	private boolean live = true;


	private static Random r = new Random(); 
	
	public Blood(TankWarFrame f)
	{
		x = r.nextInt(TankWarFrame.GAME_WIDTH - 100) + 50;
		y = r.nextInt(TankWarFrame.GAME_HEIGHT - 100) + 50;
		this.twf = f;
	}
	
	public boolean isLive()
	{
		return live;
	}

	public void setLive(boolean live)
	{
		this.live = live;
	}
	
	public void draw(Graphics g)
	{
		if(!isLive())return;
		Color c = g.getColor();
		g.setColor(Color.magenta);
		g.fillRect(x, y, 10, 10);
		g.setColor(c);
		move();
	}
	
	public void move()
	{
		x = x + r.nextInt(Tank.XSPEED) + 1;
		y = y + r.nextInt(Tank.YSPEED) + 1;
		if(x > TankWarFrame.GAME_WIDTH || y >TankWarFrame.GAME_HEIGHT)
		{
			this.setLive(false);
		}
	}
	
	public Rectangle getRec()
	{
		return new Rectangle(x,y,10,10);
	}
}
