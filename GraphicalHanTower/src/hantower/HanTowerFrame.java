package hantower;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class HanTowerFrame extends JFrame
{
	private static HanTowerFrame f = new HanTowerFrame();
	public static final int FHEIGHT = 600;
	public static final int FWIDTH = 600;
	//this不能传到静态，静态不能使用非静态成员（非静态成员，必须实例化（new 对象）之后才存在，而静态不用）
	private  static Pillar ps[] = new Pillar[3];
	static
	{
		ps[0] = new Pillar(f,100,90,"A",5,"C");
		ps[1] = new Pillar(f,300,90,"B",0,null);
		ps[2] = new Pillar(f,500,90,"C",0,null);
	}
	
	
	public Pillar[] getPs()
	{
		return ps;
	}

	public void setPs(Pillar[] ps)
	{
		this.ps = ps;
	}

	//把环从A移到C，通过B，A上要移动的有num个环
	public static void move(Pillar a,Pillar b,Pillar c,int num)
	{
		if(num == 1) 
		{
			a.movePillar(c);
		}
		else
		{
			move(a,c,b,num-1);
			a.movePillar(c);
			move(b,a,c,num-1);
		}
	}
	
	public void outArr(Annulus a)
	{
		
	}
	
	public void launchFrame()
	{
	
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				System.exit(0);
			}
		});
//this.setLocation(100, 100);
//this.setSize(FWIDTH, FHEIGHT);
        this.setBounds(0,0, HanTowerFrame.FWIDTH, HanTowerFrame.FHEIGHT);//窗口缩起来,传递错了参数，HEIGHT是原有的
		//this.setResizable(false);
		this.setBackground(Color.white);
        this.setVisible(true);
        
        Thread t = new Thread(new PaintThread());
        t.start();//不是 t.run()啊！亲！
        move(ps[0],ps[1],ps[2],ps[0].getAnn().size());
	}
	
	//重写
	public void paint(Graphics g)
	{
		if(ps == null)return;
		g.clearRect(0, 0, FWIDTH, FHEIGHT);//用这个清理意见画过的东西！！！！
		for(Pillar p : ps)
		{
			p.draw(g);
		}
		
	}
	
	private class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
//System.out.println("重绘");
				try
				{
					Thread.sleep(200);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		new HanTowerFrame().launchFrame();

	}

}
