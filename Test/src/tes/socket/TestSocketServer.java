package tes.socket;

import java.net.*;
import java.io.*;

public class TestSocketServer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		InputStream in = null;
		OutputStream out = null;
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(6664);
			while(true)
			{
				Socket s = ss.accept();
				in = s.getInputStream();
				out = s.getOutputStream();
				DataInputStream dis = new DataInputStream(in);
				DataOutputStream dos = new DataOutputStream(out);
				String a = null;
				if((a=dis.readUTF()) != null)
				{
					System.out.println(a);//œ»∂¡
				}
				System.out.println("from: " + s.getInetAddress());
				System.out.println("port: " + s.getPort());
				dos.writeUTF("i am the server , hello");//∫Û–¥
				dis.close();
				dos.flush();
				dos.close();
				s.close();
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(ss != null)
			{
				try
				{
					ss.close();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

}