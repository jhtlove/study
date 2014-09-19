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
	//this���ܴ�����̬����̬����ʹ�÷Ǿ�̬��Ա���Ǿ�̬��Ա������ʵ������new ����֮��Ŵ��ڣ�����̬���ã�
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

	//�ѻ���A�Ƶ�C��ͨ��B��A��Ҫ�ƶ�����num����
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
        this.setBounds(0,0, HanTowerFrame.FWIDTH, HanTowerFrame.FHEIGHT);//����������,���ݴ��˲�����HEIGHT��ԭ�е�
		//this.setResizable(false);
		this.setBackground(Color.white);
        this.setVisible(true);
        
        Thread t = new Thread(new PaintThread());
        t.start();//���� t.run()�����ף�
        move(ps[0],ps[1],ps[2],ps[0].getAnn().size());
	}
	
	//��д
	public void paint(Graphics g)
	{
		if(ps == null)return;
		g.clearRect(0, 0, FWIDTH, FHEIGHT);//�����������������Ķ�����������
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
//System.out.println("�ػ�");
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
