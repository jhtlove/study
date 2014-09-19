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
		//匿名类
		this.addWindowListener(
				new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
				disconServer();//关闭窗口就断开与服务器连接
			}
		}
				);
		//Interface ActionListener
		tf.addKeyListener(new MyListener());
		this.setVisible(true);
		conServer();//显示窗口就连接服务器
		
		
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
						sendStr(str);//客户端发给服务器端，再由服务器发给其他客户端，这么个流程
					}
					ta.setText(str);
					tf.setText("");
				}
				else
				{
					System.out.println("不能发送空消息");//判断不正确
				}
			}
		}
	}
	
	public void conServer()
	{
		
		try
		{
			s = new Socket("127.0.0.4",8888);//这样就连接上服务器了
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
		//conServer();//每次发送一次就新建立一下连接，不合适，每一个客户端建立一次连接
		try
		{
			//DataOutputStream dos = new DataOutputStream(s.getOutputStream());//每次发送都拿到一下这个管道，可以连接上就拿，只拿一次
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
