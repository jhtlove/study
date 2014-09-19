package test.gui;
import java.awt.*;
import java.awt.event.*;
public class TestEvent
{

	public static void main(String[] args)
	{
		Button b = new Button("botton1");
		MyListener l = new MyListener();
		b.addActionListener(l);//注册事件监听器。多态 public void addActionListener(ActionListener l)对象当成接口类型传进去
		Frame f = new Frame("Test event");
		//f.setLayout(new BorderLayout());
		f.add(b,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}

}

//实现接口
class MyListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("button1 is clicked");
		
	}
}

