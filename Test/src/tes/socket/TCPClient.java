package tes.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient
{
	public static void main(String[] args)
	{
		Socket s = null;
		try
		{
			s = new Socket("127.0.0.1",8888);//�������ӣ�client�ˣ����ѡһ���˿�
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			OutputStream os =  s.getOutputStream();//��client������ܵ�
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("hello,server!");
			dos.flush();

			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dos.close();
			dis.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
