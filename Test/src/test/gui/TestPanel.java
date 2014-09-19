package test.gui;

import java.awt.*;

public class TestPanel
{

	public static void main(String[] args)
	{
		Frame f = new Frame("Test Panel");
		f.setBounds(40, 40, 100, 100);
		Panel p = new Panel();
		p.setBackground(Color.red);
		p.setBackground(new Color(12,215,59));
		p.setLocation(20, 20);
		p.setVisible(true);
		f.add(p);
		f.setVisible(true);
		MyFrame11 mf = new MyFrame11(200,200,300,300);
		mf.setVisible(true);
		
	}

}

class MyFrame11 extends Frame
{
	Panel p1,p2,p3,p4;
	MyFrame11(int x,int y,int w,int h)
	{
		setBounds(x,y,w,h);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p1.setBounds(0, 0, w/2, h/2);
		p2.setBounds(0 + w/2,0, w/2, h/2);
		p3.setBounds(0, 0+ h/2, w/2, h/2);
		p4.setBounds(0 + w/2, 0 + h/2, w/2, h/2);
		p1.setBackground(Color.blue);
		p2.setBackground(Color.red);
		p3.setBackground(Color.yellow);
		p4.setBackground(Color.gray);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
	}
}
