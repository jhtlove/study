package com.mychat;
import java.net.*;
import java.io.*;
public class ChatServer
{
	
	public static void main(String[] args)
	{
		ServerSocket ss = null;
		DataInputStream dis = null;
		Socket s = null;
		boolean isStarted = false;//服务器这边自己启动了，就一直接收客户端的连接
		try
		{
			ss = new ServerSocket(8888);//服务器启动了；监听该端口
		}
		catch(IOException e)
		{
			//异常处理，可以更精细。服务器端一定会遇到各种异常，比如突然断电，需要好好处理
			System.out.println("server failed");
			e.printStackTrace();
			System.exit(0);
		}
		try
		{
			isStarted = true;
			while(isStarted)
			{
				boolean isConnected = false;//如果有客户端连接上了
				s = ss.accept();//等待客户端的连接
System.out.println("a client connected");
				isConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while(isConnected)
				{
					System.out.println(dis.readUTF());//，阻塞式方法，傻傻等待第一个客户端发送的所有消息
				}
				//dis.close();//isConnected 为 false，如果s = ss.accept();产生异常则跳转处理异常。所有这句话在里面没有效果了
				
			}
		}
		catch (EOFException e)
		{
			System.out.println("client closed");

			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		}
		catch(IOException e)
		{
			System.out.println("连接中断");
			e.printStackTrace();//会显示异常信息
		}
		finally
		{
			try
			{
				if(s != null)
				{
					s.close();
				}
				if(dis != null)
				{
					dis.close();
				}
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}

class MyServer implements Runnable
{
	public void run()
	{
		
	}
}
