package com.mychat;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.io.*;


public class ChatClient extends Frame
{
	Socket s = null;
	DataOutputStream dos = null;
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
		add(ta,BorderLayout.CENTER);
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
				disconServer();//�رմ��ھͶϿ������������
			}
		}
				);
		//Interface ActionListener
		tf.addKeyListener(new MyListener());
		this.setVisible(true);
		conServer();//��ʾ���ھ����ӷ�����
		
		
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
					if(s != null)
					{
						sendStr(str);//�ͻ��˷����������ˣ����ɷ��������������ͻ��ˣ���ô������
					}
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
			s = new Socket("127.0.0.4",8888);//�����������Ϸ�������
System.out.println("connect to server");
			dos = new DataOutputStream(s.getOutputStream());
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
	
	public void disconServer()
	{
		if(s != null)
		{
			try
			{
				s.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(dos != null)
		{
			try
			{
				dos.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendStr(String str)
	{
		//conServer();//ÿ�η���һ�ξ��½���һ�����ӣ������ʣ�ÿһ���ͻ��˽���һ������
		try
		{
			//DataOutputStream dos = new DataOutputStream(s.getOutputStream());//ÿ�η��Ͷ��õ�һ������ܵ������������Ͼ��ã�ֻ��һ��
			dos.writeUTF(str);
			dos.flush();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
