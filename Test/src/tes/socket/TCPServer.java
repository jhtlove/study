package tes.socket;
//先起server再起client
import java.net.*;
import java.io.*;

public class TCPServer
{
	public static void main(String[] args)
	{
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(8888);//监听该端口
			
			while(true)
			{
				Socket s = ss.accept();//accept阻塞式；不断等待
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());//readUTF也需要等待
				System.out.println("A client connected");
				try
				{
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF(s.getInetAddress() + "#port:" + s.getPort());
				dos.close();
				dis.close();
				s.close();//不是关服务器端的ss
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ss.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
