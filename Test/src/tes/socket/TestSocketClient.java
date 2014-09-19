package tes.socket;

import java.net.*;
import java.io.*;

public class TestSocketClient
{
	public static void main(String[] args)
	{
		Socket s = null;
		try
		{
			s = new Socket("127.2.3.1", 6664);
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF("hello,i am a client");//��Ϸ���ˣ���д�������ȻreadUTF����ʽ�ȴ�
			String a = null;
			if ((a=dis.readUTF()) != null)
			{
				System.out.println(a);
			}

		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

