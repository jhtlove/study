package test.gui;

import java.awt.*;

public class TestMultiFrame
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyFrame f1 = new MyFrame(100,100,200,200,Color.blue);
		MyFrame f2 = new MyFrame(300,100,200,200,Color.green);
		MyFrame f3 = new MyFrame(100,300,200,200,Color.gray);
		MyFrame f4 = new MyFrame(300,300,200,200,Color.red);

	}
	
	

}

class MyFrame extends Frame
{
	private static int id = 0;
	public MyFrame(int x,int y, int w,int h, Color c)
	{
		super("MyFrame" + ++id);//����д�ڵ�һ�У����и�������
		this.setBounds(x, y, w, h);
		this.setLayout(null);//���Լ����ڲ��Ĳ��ֹ�����������Ϊ��
		this.setBackground(c);
		this.setVisible(true);
	}
}
