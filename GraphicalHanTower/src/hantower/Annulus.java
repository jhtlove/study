package hantower;

import java.awt.*;

//����;���β���������λ��������λ�þ��������Զ���Ϊ���ӵ��ڲ�����ܸ�����
public class Annulus
{
	public static final int BASICW = Pillar.W + 20;//��С���Ŀ��
	public static final int H = 20;//��ȹ̶�20
	private int level = 0 ;//���ļ��𣬾�����С��С
	private int x;
	private int y;
	private Color c = Color.red;
//private String locName;//����������
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
if(this == null) return;//ȥ���Ĳ�Ҫ���ˣ�
		Color c = g.getColor();
		g.setColor(this.c);
		g.fillRect(x, y, (BASICW + level * 20), H-5);
		g.setColor(Color.green);
		g.drawRect(x, y, (BASICW + level * 20), H-5);
		g.setColor(c);
	}
}
