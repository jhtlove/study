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
			dos.writeInt(i);// д���ֽ�������
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
			// UDP���������ӣ�ÿһ�����ݶ�Ҫ����·���������͵�����ȥ
			dp = new DatagramPacket(b, b.length, new InetSocketAddress(
					"192.168.2.1", 5678));//ip��ַ��Ҫָ�򱾵أ� ipconfig����鿴ip
			ds = new DatagramSocket(9999);// ռ��9999�˿ڣ��򱾵ص�ip��5678�˿ڷ�������
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
