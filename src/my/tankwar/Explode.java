package my.tankwar;

import java.awt.*;

public class Explode
{
	private int x;
	private int y;
	private int step = 0;
	private boolean live = true;
	
	private TankWarFrame twf = null;
	private int[] diameter = {4,9,15,30,40,27,16,5};
	
	public Explode(int x,int y,TankWarFrame f)
	{
		this.x = x;
		this.y = y;
		this.twf = f;
	}
	
	public void draw(Graphics g)
	{
		if(!live)
		{
			twf.explodes.remove(this);
			return;
		}
		if(step == diameter.length)
		{
			live = false;
			step = 0;//ÓÐ×÷ÓÃÂð£¿
			return;
		}
		Color c = g.getColor();
		g.setColor(new Color(238,32,177));
		g.fillOval(x, y, diameter[step], diameter[step]);
		step++;
		g.setColor(c);
	}
}
