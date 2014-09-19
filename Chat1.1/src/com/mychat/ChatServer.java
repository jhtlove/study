package com.mychat;
//����˼·���첽ģ�ͺͶ��̡߳����ö��̣߳��ѽ��տͻ������ӣ��ʹ���ͻ������ݣ��ֱ�ŵ���ͬ���߳����档
//���߳�ֻ�ܽ��տͻ��˵����ӣ�ÿһ���ͻ��˵ľ��崦���װ����һ���߳�����
//��̬�������治��ֱ��new�����ڲ��ࣺ��Ҫ���ⲿ��װ����󣬲���ȥnew�ڲ��������дһ��
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer
{
	private ArrayList<Socket> allS = null;//����ÿһ���ͻ��˵����ӣ� ArrayList<HandleClient>�����ʣ�
	ArrayList<HandleClient> clients = null;
	
	public static void main(String[] args)
	{
		new ChatServer().startServer();//�ھ�̬�����У�new�����ⲿ��װ�࣬�������ڲ���
	}
	
	public void startServer()
	{
		ServerSocket ss = null;
		allS = new ArrayList<Socket>();
		clients = new ArrayList<HandleClient>();
		boolean isStarted = false;
		try
		{
			ss = new ServerSocket(8888);// �����������ˣ������ö˿�
		}
		catch (IOException e)
		{
			// �쳣�������Ը���ϸ����������һ�������������쳣������ͻȻ�ϵ磬��Ҫ�úô���
			System.out.println("server failed");
			e.printStackTrace();
			System.exit(0);
		}

			isStarted = true;
			// ����������Լ������ˣ���һֱ���տͻ��˵�����
			try
			{
				while (isStarted)
				{
					Socket s = null;
					s = ss.accept();
					allS.add(s);
					System.out.println("a client connected");
					HandleClient hc = new HandleClient(s);//�ڷ�����new�ڲ���HandleClient
					clients.add(hc);
					Thread t = new Thread(hc);
					t.start();
				}			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(ss != null)
				{
					try
					{
						ss.close();
						isStarted = false;
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
	}

	//����ÿ�����������Ŀͻ����շ����ݵ���
	private class HandleClient implements Runnable
	{
		private Socket s = null;//�����ӣ�����
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean isConnected = false;
		private String str = null;
		
		//���ù��췽������ݵش��ݲ�����
		//���뱻�����������Ҳ��Ǽ���Ϊ�����Ĳ�����������Ϊ��Ĳ�����
		//�����������Ҫ����������Ա���� s��
		public HandleClient(Socket s)
		{
			this.s = s;
			try
			{
				//��ʼ���������ڹ��캯��������������·ͨ�����ȽϺ��ʵķ����Ϳ���
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			isConnected = true;
		}
		
		public void sendM(String str)
		{
			try
			{
				dos.writeUTF(str);//���ڼ����е�˭��������sendM����������remove��this��ȥ��
			}
			catch (IOException e)
			{
				System.out.println("");
				e.printStackTrace();
			}
		}
		
		public void run()
		{
			
			try
			{
				while(isConnected)
				{
					str = dis.readUTF();//�õ���ǰ�ͻ��˷���������
					//System.out.println(str);
					for(int i=0;i<clients.size();i++)
					{
						HandleClient c = clients.get(i);
						c.sendM(str);
					}
//					Iterator<Socket> i = allS.iterator();
//					while(i.hasNext())
//					{
//						DataOutputStream dos = new DataOutputStream(i.next().getOutputStream());
//						dos.writeUTF(str);//����д�ظ������������Ŀͻ��ˣ������Լ���
//						//���ֻȥ�õ�ǰ�ͻ������ӵ�dos���Ǿ�ֻ�����˵�ǰ�ͻ���
//					}
				}
			}
			catch (EOFException e)
			{
				System.out.println("client closed");
				//allS.remove(s);
			}
			catch (IOException e)
			{
				System.out.println("���������ж�");
				//allS.remove(s);
				//e.printStackTrace();// ����ʾ�쳣��Ϣ
			}
			finally//ͳһ���ڣ������Ƿ����쳣����ִ�С������ֻ�з����쳣������try�е�whileѭ��
			{
				clients.remove(this);//�Լ��������⣬�Ͱ��Լ�remove��
				try
				{
					if (s != null)
					{
						//allS.remove(s);
						s.close();
					}
					if (dis != null)
					{
						dis.close();
					}
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
}


