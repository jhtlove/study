package mytest.snake;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import mytest.snake.Snake.Direction;
/**
 * 贪食蛇的主窗体类
 * @author Administrator
 *
 */
public class SnakeClient extends Frame
{

	public static void main(String[] args)
	{
		new SnakeClient().launchFrame();

	}
	
	
	private static Random r = new Random();
	/**
	 * 游戏的高度
	 */
	public static final int GAME_HEIGHT = 500;//常量一般是public static final的
	/**
	 * 游戏的宽度
	 */
	public static final int GAME_WIDTH = 600;//以后可能需要多处改变的量定义为常量
	private boolean gameOver = false;
	Thread t = null;
	Snake s = new Snake(100,100,this);
	Blood b = new Blood(r.nextInt(SnakeClient.GAME_WIDTH - Blood.w -50)+ 50,r.nextInt(SnakeClient.GAME_HEIGHT - Blood.h - 50)+ 50);
	ArrayList<Things> things = new ArrayList<Things>();
	
	public void launchFrame()
	{
		things.add(s);
		things.add(b);
		t = new Thread(new PaintThread());
		t.start();
		new Thread(new Appear()).start();
		this.setBounds(100, 100, GAME_WIDTH, GAME_HEIGHT);
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				gameOver = true;
				setVisible(false);
				try
				{
					t.join();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		this.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				s.keyPressed(e);
			}
			
		});
		this.setVisible(true);
	}
	

	
	@Override
	public void paint(Graphics g)
	{
		for(int i=0;i<things.size();i++)
		{
			things.get(i).draw(g);
		}
	}

	private class Appear implements Runnable
	{

		@Override
		public void run()
		{
			while(!gameOver)
			{
				if(!b.isLive())
				{
					things.remove(b);
					b = new Blood(r.nextInt(SnakeClient.GAME_WIDTH - Blood.w -50)+ 50,r.nextInt(SnakeClient.GAME_HEIGHT - Blood.h - 50)+ 50);
					things.add(b);
				}
				
			}
		}
		
	}

	private class PaintThread implements Runnable
	{

		@Override
		public void run()
		{
			while(!gameOver)
			{
				repaint();
				try
				{
					Thread.sleep(200);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
