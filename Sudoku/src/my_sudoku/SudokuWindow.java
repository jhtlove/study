package my_sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SudokuWindow 
{

	public static void main(String[] args)
	{
		new MyFrame().lauchFrame();

	}

}

class MyFrame extends Frame
{
	private static final long serialVersionUID = 1L;
	private Panel p = null;
	private GridLayout l = null;

	
	private int size = 9;//  9*9 的数独
	private int arr[] = new int[size * size];
	private int blockSize = 40;//每个小方块大小
	
	
	
	public int[] getArr()
	{
		return arr;
	}

	public void lauchFrame()
	{
		this.setBounds(100, 10, blockSize * size, blockSize * size);
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(3,1));
		p = new Panel();
		l = new GridLayout(this.size + (int)Math.sqrt(this.size) -1 ,this.size + (int)Math.sqrt(this.size) - 1);
		p.setLayout(l);
		for(int i=0;i<l.getRows();i++)
		{
			for(int j=0;j<l.getColumns();j++)
			{
				TextField temp = new TextField();
				if((i + 1) % ((int)Math.sqrt(this.size) + 1) == 0 || (j + 1) % ((int)Math.sqrt(this.size) + 1) == 0)
				{
					temp.setBackground(Color.black);
				}
				else
				{
					temp.setBackground(Color.white);
					temp.setText("0");
				}
				p.add(temp);
			}
		}
		this.add(p);
		TextField result = new TextField("结果:");
		this.add(result);
		Button btn = new Button("确定");
		this.add(btn);
		//按键提交填写数据
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int count = 0;
				for(int i=0;i<p.getComponentCount();i++)
				{
					TextField tf = (TextField)p.getComponent(i);
					String s = tf.getText();
					if(tf.getBackground() != Color.black)
					{
						arr[count] = Integer.parseInt(s);
						count++;
					}
				}
				
			}});
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
			
		});
	//	this.setResizable(false);
		this.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		//g.setColor(Color.red);
		g.setColor(c);
	}
	
}
