package test.gui;

import java.awt.*;

public class TestPaint
{

	public static void main(String[] args)
	{
		new MyFrame7().launchFrame();

	}

}
class MyFrame7 extends Frame
{
	public void launchFrame()
	{
		this.setBounds(50, 50, 100, 100);
		this.setVisible(true);
	}
	//重画时候，自动调用paint
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.red);
		g.drawOval(40, 30, 20, 30);
		g.setColor(c);
	}
}