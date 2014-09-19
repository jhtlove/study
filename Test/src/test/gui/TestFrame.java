package test.gui;

import java.awt.*;

public class TestFrame
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Frame f = new Frame("My Frame");
		f.setSize(170,100);//ÏñËØ
		f.setBackground(Color.blue);
		f.setResizable(true);
		f.setLocation(200, 200);//ÆÁÄ»×ø±ê
		f.setVisible(true);
	}

}
