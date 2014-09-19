package com.mychat;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.io.*;
public class ChatClient extends Frame
{
	Socket s = null;
	TextField tf = new TextField();
	TextArea ta = new TextArea();
	
	public static void main(String[] args)
	{
		new ChatClient().launchFrame();
		

	}
	
	public void launchFrame()
	{
		tf.setText("");
		ta.setText("");
		setLocation(400,300);
		this.setSize(300,300);
		add(ta,BorderLayout.NORTH);
		add(tf,BorderLayout.SOUTH);
		pack();
		//������
		this.addWindowListener(
				new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
				);
		//Interface ActionListener
		tf.addKeyListener(new MyListener());
		this.setVisible(true);
		//conServer();
		
		
	}
	
	private class MyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			
			String str = null;
			if(e.getKeyCode() == KeyEvent.VK_ENTER )
			{
				if(tf.getText() != "")
				{
					str = ta.getText() + "\n" +tf.getText();
					sendStr(str);//�ͻ��˷����������ˣ����ɷ��������������ͻ��ˣ���ô������
					ta.setText(str);
					tf.setText("");
				}
				else
				{
					System.out.println("���ܷ��Ϳ���Ϣ");//�жϲ���ȷ
				}
			}
		}
	}
	
	public void conServer()
	{
		
		try
		{
			s = new Socket("127.0.0.1",8888);
System.out.println("connect to server");
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendStr(String str)
	{
		conServer();
		try
		{
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(str);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
