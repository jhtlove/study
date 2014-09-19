package test.gui;
import java.awt.*;
import java.awt.event.*;
public class ButtonClick
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		b2.setActionCommand("BUTTON B2");
		MyListener2 l = new MyListener2();
		b1.addActionListener(l);
		b2.addActionListener(l);
		Frame f = new Frame("test event");
		f.add(b1,BorderLayout.NORTH);
		f.add(b2,BorderLayout.CENTER);

		f.pack();
		f.setVisible(true);

	}

}
class MyListener2 implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("the clicked button is " + e.getActionCommand());//getActionCommand默认是button上的文本
		
	}
	
}