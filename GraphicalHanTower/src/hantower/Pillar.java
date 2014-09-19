package hantower;

import java.awt.*;
import java.util.ArrayList;
//柱子
public class Pillar
{
	private static HanTowerFrame f = null;
	public static final int H = 500;
	public static final int W = 40;
	private  int x;
	private  int y;
	private String name;
	private ArrayList<Annulus> ann = new ArrayList<Annulus>();//保存环
	private String desName = null;
	public static final int STEP = (Annulus.BASICW - Pillar.W) / 2;
	
	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getDesName()
	{
		return desName;
	}


	public void setDesName(String desName)
	{
		this.desName = desName;
	}


	public ArrayList<Annulus> getAnn()
	{
		return ann;
	}


	public void setAnn(ArrayList<Annulus> ann)
	{
		this.ann = ann;
	}


	//从此柱子第一个移到目标柱子des
	public void movePillar(Pillar des)
	{
		if(this.getAnn().size() == 0) return;//没东西就别移动了
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
this.desName = des.getName();//获得移动目标名
System.out.println(this.getName() + "-->" + this.getDesName());
		Annulus temp = this.getAnn().get(this.getAnn().size()-1);
		//this.getAnn().remove(this.getAnn().size()-1);//没有彻底移除掉？
		this.getAnn().remove(temp);
		temp.setY(570 - des.ann.size() * Annulus.H);
		switch(des.name)
		{
			case "A":
				temp.setX(100 - temp.getLevel()*STEP );
				break;
			case "B":
				temp.setX(300 - temp.getLevel()*STEP );
				break;
			case "C":
				temp.setX(500 - temp.getLevel()*STEP );
				break;
		}
		des.ann.add(temp);
//System.out.println("添加环形");
		
		
		if(f.getPs()[0].getAnn().size()==0 && f.getPs()[1].getAnn().size()==0)
		{
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	
	public Pillar()
	{
		
	}
	
	
	public Pillar(HanTowerFrame f,int x,int y,String name,int num,String desName)
	{
//System.out.println("初始化一个柱子上的环");
		this.desName = desName;
		this.f = f;
		this.x = x;
		this.y = y;
		this.name = name;
		switch(name)
		{
			case "A":
System.out.println("A");
				for(int i=num;i>0;i--)
				{
					ann.add(new Annulus(i,100 - i*STEP,570 - (num-i)*Annulus.H));
				}
				break;
			case "B":
				for(int i=num;i>=1;i--)
				{
					ann.add(new Annulus(i,300 - i*STEP,590 - (6-i)*Annulus.H));
				}
				break;
			case "C":
				for(int i=num;i>=1;i--)
				{
					ann.add(new Annulus(i,500 - i*STEP,590 - (6-i)*Annulus.H));
				}
				break;
		}
	}
	
	public void draw(Graphics g)
	{
		if(this == null) return;
		Color c = g.getColor();
		g.setColor(Color.black);
		g.drawRect(x, y, W, H);
		g.setColor(c);
		
		if(this.ann.size() > 0)//有饼
		{
			//增强for循环会把remove掉的也显示出来？？
			for(int i=0;i<this.ann.size();i++)
			{
//System.out.println("画环形" + a.getX() + "," + a.getY());
				this.ann.get(i).draw(g);
			}
		}
//		
//		if(desName!=null)
//		{
//			switch(desName)
//			{
//				case "A":
//					this.movePillar(f.getPs()[0]);
//					break;
//				case "B":
//					this.movePillar(f.getPs()[1]);
//					break;
//				case "C":
//					this.movePillar(f.getPs()[2]);
//					break;
//				default:
//					{
//System.out.println("desName" + desName);
//					}
//			}
//		}
			
	}
}
