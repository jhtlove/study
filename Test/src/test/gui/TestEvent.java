package test.gui;
import java.awt.*;
import java.awt.event.*;
public class TestEvent
{

	public static void main(String[] args)
	{
		Button b = new Button("botton1");
		MyListener l = new MyListener();
		b.addActionListener(l);//ע���¼�����������̬ public void addActionListener(ActionListener l)���󵱳ɽӿ����ʹ���ȥ
		Frame f = new Frame("Test event");
		//f.setLayout(new BorderLayout());
		f.add(b,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}

}

//ʵ�ֽӿ�
class MyListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("button1 is clicked");
		
	}
}

