package tes.socket;

import java.io.*;
import java.net.*;

//UDP本身，没有客户端和服务端之分
public class UDPServer
{
	public static void main(String[] args)
	{
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		DatagramSocket ds = null;
		//Creates a ByteArrayInputStream so that it uses buf as its buffer array. 
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bis);
		try
		{
			ds = new DatagramSocket(5678);
		} catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true)
		{
			try
			{
				ds.receive(dp);// 接收包，存到buf 字节数组中
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				ds.close();
			}
			// System.out.println(new String(buf,0,dp.getLength()));
			try
			{
				System.out.println(dis.readInt());
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
