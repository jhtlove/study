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
	TextField tf = new TextField();//��Աֱ�ӳ�ʼ��,�Ժ��ʼ���������ԡ�
	TextArea ta = new TextArea();
	Button b = new Button("����");
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
		//������
		this.addWindowListener(
				new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				disconServer();//�رմ��ھͶϿ������������
				System.exit(0);
			}
		}
				);
		//Interface ActionListener
		tf.addKeyListener(new MyListener());//�ı��У�����enter����
		b.addActionListener(new MyListener1());
		this.setVisible(true);
		conServer();//��ʾ���ھ����ӷ�����
		new Thread(new HandleServer()).start();//�������Ժ󣬾������߳̽�������
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
						sendStr(name + ": " + str);//�ͻ��˷����������ˣ����ɷ��������������ͻ��ˣ���ô������
					}
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
			dis = new DataInputStream(s.getInputStream());
			isConnected = true;
		}
		catch (UnknownHostException e)
		{
			System.out.println("���ӳ���1");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("���ӳ���2");
			e.printStackTrace();
		}
//		while(isConnected)
//		{
//			//���Ϸ������ˣ��Ͳ��Ͻ������пͻ��ˣ������Լ�����������
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
				System.out.println("�Ͽ�����");
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
	//������һ���̣߳�ȥ������տͻ�������
	private class HandleServer implements Runnable
	{
		//����ʵ�ֽӿڵģ��Ͳ��ü̳У���Ϊ�������
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
					System.out.println("�Ͽ�����");
					//e.printStackTrace();
				}
			}
		}
		
	}
}

class UserLogin extends Frame
{
	//String name;//��ô��name����ChatClient���棿�ڲ��ࣿ���жԷ�������,ͨ�����캯�����������
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
		Button b = new Button("ȷ��");
		this.add(tf,BorderLayout.CENTER);
		this.add(b, BorderLayout.SOUTH);
		b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String name = tf.getText();
				setVisible(false);
				System.out.println("�û� �� " + name);
				cc.setName(name);
				//System.out.println(cc.getName());
				//System.out.println("����");
				//System.exit(0);//��ֹ����ǰ���ڣ����������ˣ���ôֻ�ر�һ�����ڣ�
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
				System.exit(0);//��ֹ����ǰ���ڣ�����������
			}
		});
		this.pack();
		this.setVisible(true);
	}
	
}
