package tes.socket;

import java.io.*;
import java.net.*;

public class UDPClient
{
	public static void main(String[] args)
	{
		int i = 100;
		// The buffer capacity is initially 32 bytes, though its size increases
		// if necessary.
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		try
		{
			dos.writeInt(i);// 写入字节数组中
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// String s = "hello";
		// byte b[] = s.getBytes();
		byte b[] = bos.toByteArray();
		DatagramPacket dp = null;
		DatagramSocket ds = null;
		try
		{
			// UDP面向无连接，每一包数据都要告诉路由器，发送到哪里去
			dp = new DatagramPacket(b, b.length, new InetSocketAddress(
					"192.168.2.1", 5678));//ip地址需要指向本地？ ipconfig命令查看ip
			ds = new DatagramSocket(9999);// 占据9999端口，向本地的ip的5678端口发送数据
			try
			{
				ds.send(dp);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
