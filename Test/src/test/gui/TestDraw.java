package test.gui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TestDraw
{

	public static void main(String[] args)
	{
		
		MyFrame8 f = new MyFrame8();
	}

}

class MyFrame8 extends Frame
{
	ArrayList<Point> points = null;
	
	public MyFrame8()
	{
		points = new ArrayList<Point>();
		this.setBounds(10, 10, 400, 400);
		this.setVisible(true);
		MyListener8 l = new MyListener8();
		this.addMouseListener(l);
	}
	
	public void addPoint(Point p)
	{
		points.add(p);
	}
	
	public void paint(Graphics g)
	{
		Iterator<Point> i = points.iterator();
		Color c = g.getColor();
		g.setColor(Color.red);
		while(i.hasNext())
		{
			Point p = i.next();
			g.fillOval(p.x, p.y, 20, 20);
		}
		g.setColor(c);//恢复现场
	}
}
//如果直接去实现MouseListener接口，要实现全部的虚函数，不方便
class MyListener8 extends MouseAdapter
{
	public void mouseClicked(MouseEvent e)
	{
		Point p = new Point(e.getX(),e.getY());
		MyFrame8 f = (MyFrame8)e.getSource();
		f.addPoint(p);
		f.repaint();//屏幕重绘 ； 先调用update()双缓冲，再 paint() 该方法没有传画笔Graphics对象
	}
	
}