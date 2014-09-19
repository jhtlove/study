package hantower;

import java.awt.*;

//环形;环形不够独立，位置由柱子位置决定，所以定义为柱子的内部类可能更符合
public class Annulus
{
	public static final int BASICW = Pillar.W + 20;//最小饼的宽度
	public static final int H = 20;//厚度固定20
	private int level = 0 ;//饼的级别，决定大小大小
	private int x;
	private int y;
	private Color c = Color.red;
//private String locName;//所在柱子名
	Annulus()
	{
		
	}
	
	Annulus(int level,int x,int y)
	{
		this.x = x;
		this.y  = y;
		this.level = level;
	}
	
	
	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
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

	public void draw(Graphics g)
	{
if(this == null) return;//去掉的不要画了？
		Color c = g.getColor();
		g.setColor(this.c);
		g.fillRect(x, y, (BASICW + level * 20), H-5);
		g.setColor(Color.green);
		g.drawRect(x, y, (BASICW + level * 20), H-5);
		g.setColor(c);
	}
}
