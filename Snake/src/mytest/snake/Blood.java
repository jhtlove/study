package mytest.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Blood extends Things
{

	boolean live = true;
	private int x,y;
	public static final int w = 15;
	public static final int h = 15;
	SnakeClient sc = null;
	
	public boolean isLive()
	{
		return live;
	}

	public void setLive(boolean live)
	{
		this.live = live;
	}

	public Blood(int x,int y,SnakeClient sc)
	{
		this.x = x;
		this.y = y;
		this.sc = sc;
	}
	
	public Blood(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g)
	{
		if(!live)return;
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.fillRect(x, y, w, h);
		g.setColor(c);
	}
	
	public Rectangle getR()
	{
		return new Rectangle(x,y,w,h);
	}
	

	
}
