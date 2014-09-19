package test.gui;

import java.awt.*;

public class CenterPanel
{

	public static void main(String[] args)
	{
		MyFrame1 f = new MyFrame1(100,200,500,400);

	}

}

class MyFrame1 extends Frame
{
	Panel p1;//,p2,p3,p4;
	MyFrame1(int x,int y,int w,int h)
	{
		super("Center Panel");
		setLayout(null);//这句话不能少，否则一个panel充满了整个frame
		setBounds(x,y,w,h);
		setVisible(true);
		setBackground(Color.gray);
		p1 = new Panel(null);//p的visible可以省略，不设置
		//p2 = new Panel();
		//p3 = new Panel();
		//p4 = new Panel();
		p1.setBounds(w/4, h/4, w/2, h/2);
//		p2.setBounds(0 + w/2,0, w/2, h/2);
//		p3.setBounds(0, 0+ h/2, w/2, h/2);
//		p4.setBounds(0 + w/2, 0 + h/2, w/2, h/2);
		p1.setBackground(Color.blue);
//		p2.setBackground(Color.red);
//		p3.setBackground(Color.yellow);
//		p4.setBackground(Color.orange);
		add(p1);
//		add(p2);
//		add(p3);
//		add(p4);
		
	}
//	Panel p;
//	MyFrame1(int x ,int y,int w,int h)
//	{
//		
//		 p = new Panel();
//		add(p);
//		p.setBackground(Color.white);
//		p.setLocation(w/4, h/4);
//		p.setSize(w/2, h/2);
//		p.setVisible(true);
//		
//		setBackground(Color.blue);
//		setBounds(x,y,w,h);
//		setVisible(true);
//	}
}