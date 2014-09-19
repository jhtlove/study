package my.tankwar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Explode
{
	private int x;
	private int y;
	private int step = 0;
	private boolean live = true;
	
	private TankWarFrame twf = null;
//	private int[] diameter = {4,9,15,30,40,27,16,5};
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();//ͨ�����߰�����Ӳ���ϵ�ͼƬ�õ��ڴ�������
	private static Image imgs[] =
			{
		//ͨ������ָ�������·������Ե�ǰclass�ļ�����������·��������·�������˻���������·�����޸���Դ����������
		//ͨ��URL��URL��һ�޶�ָ��ĳ����Դ�ļ�����λ�ã�������������ֻҪ��classpath�£��ӵ��ĸ��������涼������
				tk.getImage(Explode.class.getClassLoader().getResource("images/1.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/2.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/3.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/4.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/5.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/6.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/7.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/8.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/9.gif")),
				tk.getImage(Explode.class.getClassLoader().getResource("images/10.gif"))
//				tk.getImage(Explode.class.getResource("images/1.gif")),
//				tk.getImage(Explode.class.getResource("images/2.gif")),
//				tk.getImage(Explode.class.getResource("images/3.gif")),
//				tk.getImage(Explode.class.getResource("images/4.gif")),
//				tk.getImage(Explode.class.getResource("images/5.gif")),
//				tk.getImage(Explode.class.getResource("images/6.gif")),
//				tk.getImage(Explode.class.getResource("images/7.gif")),
//				tk.getImage(Explode.class.getResource("images/8.gif")),
//				tk.getImage(Explode.class.getResource("images/9.gif")),
//				tk.getImage(Explode.class.getResource("images/10.gif"))
			};
	/*
	 * private static Image imgs[]= null;
	 * static
	 * {
	 *��̬����������֤class��һ�α�load���ڴ�ʱ��ִ�иöδ��롣���ʺϸ���������ʼ��
	 * 		imgs = new Image[]
	 * 		{
	 * 			tk.getImage(Explode.class.getResource("images/0.gif")),
				tk.getImage(Explode.class.getResource("images/1.gif")),
				tk.getImage(Explode.class.getResource("images/2.gif")),
				tk.getImage(Explode.class.getResource("images/3.gif")),
				tk.getImage(Explode.class.getResource("images/4.gif")),
				tk.getImage(Explode.class.getResource("images/5.gif")),
				tk.getImage(Explode.class.getResource("images/6.gif")),
				tk.getImage(Explode.class.getResource("images/7.gif")),
				tk.getImage(Explode.class.getResource("images/8.gif")),
				tk.getImage(Explode.class.getResource("images/9.gif")),
				tk.getImage(Explode.class.getResource("images/10.gif"))
	 * 		}
	 * 		System.out.println("������ԷŴ���");
	 * }
	 */
	public Explode(int x,int y,TankWarFrame f)
	{
		this.x = x;
		this.y = y;
		this.twf = f;
	}
	
	public void draw(Graphics g)
	{
		if(!live)
		{
			twf.explodes.remove(this);
			return;
		}
		if(step == imgs.length)
		{
			live = false;
			step = 0;//��������
			return;
		}
//System.out.println(Explode.class.getResource("images/0.gif")); //null?
		g.drawImage(imgs[step], x, y, null);
		step++;
	}
}
