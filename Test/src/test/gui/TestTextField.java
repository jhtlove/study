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
		tf.setEchoChar('*');//���û����ַ�
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
		TextField tf = (TextField)e.getSource();//�¼�Դ,ͨ���¼������getSource�������õ�Object���ͣ�ת��һ��
		System.out.println(tf.getText());
		tf.setText("");
		
	}
	
}