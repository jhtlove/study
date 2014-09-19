package com.mychat;
//两种思路：异步模型和多线程。采用多线程：把接收客户端连接，和处理客户端数据，分别放到不同的线程里面。
//主线程只管接收客户端的连接，每一个客户端的具体处理包装到另一个线程类中
//静态方法里面不能直接new出来内部类：先要有外部包装类对象，才能去new内部类对象。先写一个
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer
{
	private ArrayList<Socket> allS = null;//保存每一个客户端的连接； ArrayList<HandleClient>更合适？
	ArrayList<HandleClient> clients = null;
	
	public static void main(String[] args)
	{
		new ChatServer().startServer();//在静态方法中，new的是外部包装类，而不是内部类
	}
	
	public void startServer()
	{
		ServerSocket ss = null;
		allS = new ArrayList<Socket>();
		clients = new ArrayList<HandleClient>();
		boolean isStarted = false;
		try
		{
			ss = new ServerSocket(8888);// 服务器启动了；监听该端口
		}
		catch (IOException e)
		{
			// 异常处理，可以更精细。服务器端一定会遇到各种异常，比如突然断电，需要好好处理
			System.out.println("server failed");
			e.printStackTrace();
			System.exit(0);
		}

			isStarted = true;
			// 服务器这边自己启动了，就一直接收客户端的连接
			try
			{
				while (isStarted)
				{
					Socket s = null;
					s = ss.accept();
					allS.add(s);
					System.out.println("a client connected");
					HandleClient hc = new HandleClient(s);//在方法中new内部类HandleClient
					clients.add(hc);
					Thread t = new Thread(hc);
					t.start();
				}			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(ss != null)
				{
					try
					{
						ss.close();
						isStarted = false;
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
	}

	//处理每个连接上来的客户端收发数据的类
	private class HandleClient implements Runnable
	{
		private Socket s = null;//半连接，插座
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean isConnected = false;
		private String str = null;
		
		//利用构造方法，快捷地传递参数；
		//“想被传进来，并且不是简单作为函数的参数，而是作为类的参数；
		//于是这个类中要设计有这个成员变量 s”
		public HandleClient(Socket s)
		{
			this.s = s;
			try
			{
				//初始化工作，在构造函数中做；条条大路通罗马，比较合适的方法就可以
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			isConnected = true;
		}
		
		public void sendM(String str)
		{
			try
			{
				dos.writeUTF(str);//不在集合中的谁，调用了sendM方法，就用remove（this）去掉
			}
			catch (IOException e)
			{
				System.out.println("");
				e.printStackTrace();
			}
		}
		
		public void run()
		{
			
			try
			{
				while(isConnected)
				{
					str = dis.readUTF();//拿到当前客户端发出的数据
					//System.out.println(str);
					for(int i=0;i<clients.size();i++)
					{
						HandleClient c = clients.get(i);
						c.sendM(str);
					}
//					Iterator<Socket> i = allS.iterator();
//					while(i.hasNext())
//					{
//						DataOutputStream dos = new DataOutputStream(i.next().getOutputStream());
//						dos.writeUTF(str);//数据写回各个连接上来的客户端（包括自己）
//						//如果只去拿当前客户端连接的dos，那就只发回了当前客户端
//					}
				}
			}
			catch (EOFException e)
			{
				System.out.println("client closed");
				//allS.remove(s);
			}
			catch (IOException e)
			{
				System.out.println("连接意外中断");
				//allS.remove(s);
				//e.printStackTrace();// 会显示异常信息
			}
			finally//统一出口，无论是否发生异常都会执行。而这里，只有发生异常才跳出try中的while循环
			{
				clients.remove(this);//自己出了意外，就把自己remove掉
				try
				{
					if (s != null)
					{
						//allS.remove(s);
						s.close();
					}
					if (dis != null)
					{
						dis.close();
					}
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
}


