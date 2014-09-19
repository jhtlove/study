package mytest.snake;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Snake extends Things
{
	private SnakeClient sc = null;
	
	enum Direction{UP,RIGHT,DOWN,LEFT,STOP}
	private int x,y;//蛇头位置
	private Block head ;//蛇头，默认先向左
	private ArrayList<Block> blocks = new ArrayList<Block>(); 
	private int size = 6;//蛇的节数
	private boolean run = true;
	private boolean live = true;
	
	public Snake(int x,int y,SnakeClient sc)
	{
		this.x = x;
		this.y = y;
		this.sc = sc;
		head = new Block(x,y,Direction.RIGHT);
		head.setHead(true);
		blocks.add(head);
		
		Block pre = head;
		for(int i=0;i<size-1;i++)
		{
			Block b = new Block(x-Block.w*(i+1),y,pre.getD());
			blocks.add(b);
			pre = b;
			
		}
	}
	
	
	public void draw(Graphics g)
	{
		for(int i=0;i<blocks.size();i++)
		{
			blocks.get(i).draw(g);
		}
		if(!live)
		{
			Color c = g.getColor();
			g.setColor(Color.red);
			g.drawString("Game Over", 30, 50);
			g.setColor(c);
			return;
		}
		else if(run)
		{
			if(head.x < 0 || head.y <15 || head.x > SnakeClient.GAME_WIDTH - Block.w || head.y > SnakeClient.GAME_HEIGHT - Block.h || hitSelf())
			{
				live = false;
			}
			move();
		}

	}
	
	public boolean hitSelf()
	{
		for(int i=2;i<blocks.size();i++)
		{
			Block b = blocks.get(i);
			if(head.getR().intersects(b.getR()))
				return true;
		}
		return false;
	}
	
	public boolean eat(Blood b)
	{
		if(head.getR().intersects(b.getR())&& b.live && this.live)
		{	
			
			Block last = blocks.get(blocks.size()-1);
			Block temp = null;
			switch(last.getD())
			{
				case UP:
					temp = new Block(last.x,last.y + Block.h,last.getD());
					break;
				case RIGHT:
					temp = new Block(last.x - Block.w,last.y,last.getD());
					break;
				case DOWN:
					temp = new Block(last.x ,last.y - Block.h,last.getD());
					break;
				case LEFT:
					temp = new Block(last.x + Block.w,last.y,last.getD());
					break;
			}
			blocks.add(temp);
			
			//b.live = false;
			b.setLive(false);
			return true;
		}
		return false;
	}
	
	public void move()
	{
		eat(sc.b);
		for(int i=0;i<blocks.size();i++)
		{
			Block b = blocks.get(i);
			b.move();//每个方块自己运动，有方向就可以动
		}
		locateD();//按自己当前方向（当前方向是它前一点的方向）移动一步后，再重新根据前一点方向定位一下
	}
	
	public void locateD()
	{
		for(int i=blocks.size()-1;i>0;i--)
		{
			Block b = blocks.get(i);
			Block pre = blocks.get(i-1);
			b.setD(pre.getD());
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int k = e.getKeyCode();
		switch(k)
		{
			case KeyEvent.VK_UP:
				if(head.getD() != Direction.DOWN)
					head.setD(Direction.UP);
				break;
			case KeyEvent.VK_RIGHT:
				if(head.getD() != Direction.LEFT)
					head.setD(Direction.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				if(head.getD() != Direction.UP)
					head.setD(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				if(head.getD() != Direction.RIGHT)
					head.setD(Direction.LEFT);
				break;
			case KeyEvent.VK_SPACE:
				run = !run;
				break;

		}
	}
	
	private class Block
	{
		private int x,y;
		public static final int w = 20;
		public static final int h = 20;
		private Direction d ;
		private boolean isHead  = false;
		
		public boolean isHead()
		{
			return isHead;
		}

		public void setHead(boolean isHead)
		{
			this.isHead = isHead;
		}

		public Direction getD()
		{
			return d;
		}

		public void setD(Direction d)
		{
			this.d = d;
		}

		public Block(int x, int y, Direction d)
		{
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		public void move()
		{
			switch(d)
			{
				case UP:
					y -= Block.h;
					break;
				case LEFT:
					x -= Block.w;
					break;
				case DOWN:
					y += Block.h;
					break;
				case RIGHT:
					x += Block.w;
					break;
					
			}
		}
		
		public void draw(Graphics g)
		{
			Color c = g.getColor();
			g.setColor(Color.black);
			g.drawRect(x, y, w, h);
			if(isHead)
			{
				g.setColor(Color.red);
			}
			else
			{
				g.setColor(Color.green);
			}
			g.fillRect(x+2, y+2, w-4, h-4);
			g.setColor(c);
		}
		
		public Rectangle getR()
		{
			return new Rectangle(x,y,w,h);
		}
		
	}

}
