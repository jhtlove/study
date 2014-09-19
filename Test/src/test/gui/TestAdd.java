package test.gui;

import java.awt.*;
import java.awt.event.*;

public class TestAdd
{

	public static void main(String[] args)
	{
		MyFrame6 f = new MyFrame6("Add");

	}

}

class MyFrame6 extends Frame
{
	private static TextField a1;
	private static TextField a2;
	private static TextField result;

	public static TextField getA1()
	{
		return a1;
	}

	public static void setA1(TextField a1)
	{
		MyFrame6.a1 = a1;
	}

	public static TextField getA2()
	{
		return a2;
	}

	public static void setA2(TextField a2)
	{
		MyFrame6.a2 = a2;
	}

	public static TextField getResult()
	{
		return result;
	}

	public static void setResult(String s)
	{
		MyFrame6.result.setText(s);
	}

	MyFrame6(String s)
	{
		super(s);
		MyListener4 ls = new MyListener4(this);// this当作参数，把当前对象传过去了
		Button b = new Button("=");
		b.addActionListener(ls);
		a1 = new TextField();
		a2 = new TextField();
		result = new TextField();
		Label lb = new Label("+");
		GridLayout l = new GridLayout(1, 5);
		this.setLayout(l);
		this.add(a1);
		this.add(lb);
		this.add(a2);
		this.add(b);
		this.add(result);
		this.pack();
		this.setVisible(true);
	}
}

class MyListener4 implements ActionListener
{

	MyFrame6 f = null;// 持有对方的引用。门面模式，

	MyListener4(MyFrame6 f)
	{
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int a, b, c;
		String s1 = MyFrame6.getA1().getText();
		if (s1 == null)
		{
			a = 0;
		}
		else
		{
			a = Integer.parseInt(s1);
		}
		String s2 = MyFrame6.getA2().getText();
		if (s2 == null)
		{
			b = 0;
		}
		else
		{
			b = Integer.parseInt(s2);
		}
		c = a + b;
		MyFrame6.setResult(String.valueOf(c));// Integer.valueOf(c).toString()
	}
}
