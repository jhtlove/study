package com.mychat;
import java.net.*;
import java.io.*;
public class ChatServer
{

	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(8888);
			while(true)
			{
				Socket s = ss.accept();
System.out.println("a client connected");
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				DataInputStream dis = new DataInputStream(is);
				System.out.println(dis.readUTF());
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
