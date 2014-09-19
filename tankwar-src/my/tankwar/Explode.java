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
	
	private static Toolkit tk = Toolkit.getDefaultToolkit();//通过工具包，把硬盘上的图片拿到内存里面来
	private static Image imgs[] =
			{
		//通过名字指定：相对路径，相对当前class文件，最顶层包所在路径；绝对路径，换了机器，绝对路径上无该资源，就有问题
		//通过URL：URL独一无二指定某个资源文件所在位置；下面这样做，只要在classpath下，扔到哪个机器上面都可以用
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
	 *静态代码区，保证class第一次被load到内存时，执行该段代码。最适合给变量做初始化
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
	 * 		System.out.println("这里可以放代码");
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
			step = 0;//有作用吗？
			return;
		}
//System.out.println(Explode.class.getResource("images/0.gif")); //null?
		g.drawImage(imgs[step], x, y, null);
		step++;
	}
}
