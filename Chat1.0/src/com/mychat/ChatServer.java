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
		boolean isStarted = false;//����������Լ������ˣ���һֱ���տͻ��˵�����
		try
		{
			ss = new ServerSocket(8888);//�����������ˣ������ö˿�
		}
		catch(IOException e)
		{
			//�쳣�������Ը���ϸ����������һ�������������쳣������ͻȻ�ϵ磬��Ҫ�úô���
			System.out.println("server failed");
			e.printStackTrace();
			System.exit(0);
		}
		try
		{
			isStarted = true;
			while(isStarted)
			{
				boolean isConnected = false;//����пͻ�����������
				s = ss.accept();//�ȴ��ͻ��˵�����
System.out.println("a client connected");
				isConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while(isConnected)
				{
					System.out.println(dis.readUTF());//������ʽ������ɵɵ�ȴ���һ���ͻ��˷��͵�������Ϣ
				}
				//dis.close();//isConnected Ϊ false�����s = ss.accept();�����쳣����ת�����쳣��������仰������û��Ч����
				
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
			System.out.println("�����ж�");
			e.printStackTrace();//����ʾ�쳣��Ϣ
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
