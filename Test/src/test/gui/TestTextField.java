package test.gui;
import java.awt.*;
import java.awt.event.*;
public class TestTextField
{

	public static void main(String[] args)
	{
		MyFrame5 f = new MyFrame5();
	}

}

class MyFrame5 extends Frame
{
	MyFrame5()
	{
		TextField tf = new TextField();
		tf.setEchoChar('*');//设置回显字符
		MyListener3 l = new MyListener3();
		tf.addActionListener(l);
		this.add(tf);
		this.pack();
		this.setVisible(true);
	}
}

class MyListener3 implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		TextField tf = (TextField)e.getSource();//事件源,通过事件对象的getSource方法。拿到Object类型，转换一下
		System.out.println(tf.getText());
		tf.setText("");
		
	}
	
}