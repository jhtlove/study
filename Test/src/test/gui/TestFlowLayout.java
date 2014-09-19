package test.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class TestFlowLayout
{

	public static void main(String[] args)
	{
		Frame f = new Frame("Test Layout");
		Button b1 = new Button("open");
		Button b2 = new Button("close");
		Button b3 = new Button("click");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setSize(100,100);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.setVisible(true);
	}

}
