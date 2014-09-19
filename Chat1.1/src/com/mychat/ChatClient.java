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
	DataInputStream dis = null;
	TextField tf = new TextField();//成员直接初始化,以后初始化，都可以。
	TextArea ta = new TextArea();
	Button b = new Button("发送");
	private boolean isConnected = false;
	String name = null;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ChatClient()
	{
		name = "user";
	}
	
	public ChatClient(String name)
	{
		this.name = name;
	}
	
	public static void main(String[] args)
	{
		
		ChatClient c = new ChatClient();
		UserLogin ul = new UserLogin(c);
		ul.launchFrame();
		c.launchFrame();
		//new ChatClient().launchFrame();
	}
	
	public void launchFrame()
	{
		tf.setText("");
		ta.setText("");
		setLocation(400,300);
		this.setSize(300,300);
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		add(b,BorderLayout.NORTH);
		pack();
		//匿名类
		this.addWindowListener(
				new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				disconServer();//关闭窗口就断开与服务器连接
				System.exit(0);
			}
		}
				);
		//Interface ActionListener
		tf.addKeyListener(new MyListener());//文本行，监听enter键盘
		b.addActionListener(new MyListener1());
		this.setVisible(true);
		conServer();//显示窗口就连接服务器
		new Thread(new HandleServer()).start();//连接上以后，就启动线程接收数据
	}
	private class MyListener1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			
			sendStr(name + ": " + tf.getText());
			tf.setText("");
		}
		
	}
	private class MyListener extends KeyAdapter
	{
//		public void actionPerformed(ActionEvent e)
//		{
//			sendStr(name + ": " + tf.getText());
//			tf.setText("");
//		}
		public void keyPressed(KeyEvent e)
		{
//System.out.println("press key");
			String str = null;
			if(e.getKeyCode() == KeyEvent.VK_ENTER )
			{
				if(tf.getText() != "")
				{
					str = tf.getText();// + "\n" + ta.getText();
					if(s != null)
					{
						sendStr(name + ": " + str);//客户端发给服务器端，再由服务器发给其他客户端，这么个流程
					}
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
			dis = new DataInputStream(s.getInputStream());
			isConnected = true;
		}
		catch (UnknownHostException e)
		{
			System.out.println("连接出错1");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("连接出错2");
			e.printStackTrace();
		}
//		while(isConnected)
//		{
//			//连上服务器了，就不断接收所有客户端（包括自己）发的数据
//			String str = null;
//			try
//			{
//				 str = dis.readUTF();
//				 str = ta.getText() + "\n" + str;
//				 ta.setText(str);
//			}
//			catch (IOException e)
//			{
//				System.out.println("socket closed!");
//				e.printStackTrace();
//				System.exit(0);
//			}
//			
//		}
	}
	
	public void disconServer()
	{
		isConnected = false;
		if(dos != null)
		{
			try
			{
				dos.close();
			}
			catch (IOException e)
			{
				System.out.println("断开连接");
				e.printStackTrace();
			}
		}
		if(dis != null)
		{
			try
			{
				dis.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
//	public void receiveStr()
//	{
//		String str = null;
//		try
//		{
//			 str = dis.readUTF();
//		}
//		catch (IOException e)
//		{
//			System.out.println("error");
//			e.printStackTrace();
//			System.exit(0);
//		}
//		str = ta.getText() + "\n" + str;
//		ta.setText(str);
//	}
	//单独起一个线程，去处理接收客户端数据
	private class HandleServer implements Runnable
	{
		//能用实现接口的，就不用继承，因为它更灵活
		@Override
		public void run()
		{
			while(isConnected)
			{
				try
				{
					String str = dis.readUTF();
					ta.setText(ta.getText() + "\n" + str);
					
				}
				catch (IOException e)
				{
					System.out.println("断开连接");
					//e.printStackTrace();
				}
			}
		}
		
	}
}

class UserLogin extends Frame
{
	//String name;//怎么把name传到ChatClient里面？内部类？持有对方的引用,通过构造函数传对象进来
	TextField tf;
	Button b;
	ChatClient cc;
	
	UserLogin(ChatClient cc)
	{
		this.cc = cc;
	}
	
	public void launchFrame()
	{
		
		tf = new TextField();
		Button b = new Button("确定");
		this.add(tf,BorderLayout.CENTER);
		this.add(b, BorderLayout.SOUTH);
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String name = tf.getText();
				setVisible(false);
				System.out.println("用户 ： " + name);
				cc.setName(name);
				//System.out.println(cc.getName());
				//System.out.println("启动");
				//System.exit(0);//不止出当前窗口，整个结束了，怎么只关闭一个窗口？
			}});
		tf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER )
				{
					if(tf.getText()!=null)
					{
						cc.setName(tf.getText());
					}
					setVisible(false);
				}
			}
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);//不止出当前窗口，整个结束了
			}
		});
		this.pack();
		this.setVisible(true);
	}
	
}
