package test.gui;
import java.awt.*;
public class TestGridLayout
{

	public static void main(String[] args)
	{
		Frame f = new Frame("GridLayout");
		f.setLayout(new GridLayout(2,3));
		for(int i=0;i<5;i++)
		{
			Button b = new Button("b" + i);
			f.add(b);
		}
		f.pack();
		f.setVisible(true);
		
	}

}
