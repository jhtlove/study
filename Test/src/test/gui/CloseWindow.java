package test.gui;

import java.awt.*;
import java.awt.event.*;

public class CloseWindow
{

	public static void main(String[] args)
	{
		MyFrame9 f = new MyFrame9("close the window");

	}

}

class MyFrame9 extends Frame
{
	public MyFrame9(String s)
	{
		super(s);
		this.setBounds(10, 20, 400, 400);
		this.setVisible(true);
		//new 父类 （）加类体，接口也可以，匿名类，
		//new一个没有名字的类，把它当成WindowAdapter来用
//		this.addWindowListener(
//				new WindowAdapter()
//				{
//					public void windowClosing(WindowEvent e)
//					{
//						setVisible(false);
//						System.exit(0);
//					}
//				}
//			);
		this.addWindowListener(new MyWindowLisenter());
	}
//内部类	
//	class MyWindowLisenter extends WindowAdapter
//	{
//		public void windowClosing(WindowEvent e)
//		{
//			Frame f = (Frame)e.getSource();
//			f.setVisible(false);
//			System.exit(0);
//		}
//	}
	
}

class MyWindowLisenter extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		Frame f = (Frame)e.getSource();
		f.setVisible(false);//看不见了，但是还在背后运行
		System.exit(0);
	}
}

