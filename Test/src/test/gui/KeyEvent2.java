package test.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextLayout;

public class KeyEvent2
{

	public static void main(String[] args)
	{
		KeyFrame f = new KeyFrame();

	}

}

class KeyFrame extends Frame
{
	// KeyFrame f = null;
	Label lb = null;

	public KeyFrame()
	{
		lb = new Label("What do you click?");
		// GridBagLayout l = new GridBagLayout();
		// GridBagConstraints c = new GridBagConstraints();
		// c.gridx = 1;
		// c.gridy = 0;
		// c.fill = GridBagConstraints.BOTH;
		// Button b1 = new Button("up");
		// l.setConstraints(b1, c);
		// Button b2 = new Button("down");
		// c.gridx = 1;
		// c.gridy = 1;
		//
		// l.setConstraints(b2, c);
		// Button b3 = new Button("left");
		// c.gridx = 0;
		// c.gridy = 1;
		//
		// l.setConstraints(b3, c);
		// Button b4 = new Button("right");
		// c.gridx = 2;
		// c.gridy = 1;
		// l.setConstraints(b4, c);
		// this.add(b1);
		// this.add(b2);
		// this.add(b3);
		// this.add(b4);
		// //this.setLayout(l);
		// this.pack();

		this.setBounds(50, 50, 200, 200);
		this.add(lb);
		// this.pack();
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
				System.exit(0);
			}
		});

		this.addKeyListener(new MyKeyEvent(this));// 窗口添加监听？
		this.setVisible(true);
	}

	// 添加文本框组件后，不能监听键盘，变成在文本框直接输入文字了？

}

class MyKeyEvent extends KeyAdapter
{
	KeyFrame f = null;

	MyKeyEvent(KeyFrame f)
	{
		this.f = f;
	}

	public void keyPressed(KeyEvent e)
	{
		char keycode = e.getKeyChar();
		System.out.println(keycode);
		// f.add(new Button("button"),BorderLayout.SOUTH);
		// f.lb = new Label();
		f.lb.setText("You Click: " + keycode);
		// Frame f = (Frame)e.getSource();
		// f.add(f.lb,BorderLayout.CENTER);

	}
}
