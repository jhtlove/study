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
		//new ���� ���������壬�ӿ�Ҳ���ԣ������࣬
		//newһ��û�����ֵ��࣬��������WindowAdapter����
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
//�ڲ���	
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
		f.setVisible(false);//�������ˣ����ǻ��ڱ�������
		System.exit(0);
	}
}

