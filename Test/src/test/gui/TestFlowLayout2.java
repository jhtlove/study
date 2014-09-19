package test.gui;
import java.awt.*;

public class TestFlowLayout2
{

	public static void main(String[] args)
	{
		MyFrame3 f = new MyFrame3();

	}

}
class MyFrame3 extends Frame
{
	MyFrame3()
	{
		FlowLayout l = new FlowLayout(FlowLayout.CENTER,2,3);
		this.setLayout(l);
		//this.setSize(200, 250);
		
		for(int i=0;i<7;i++)
		{
			Button b = new Button("Button" + i);
			this.add(b);
		}
		this.pack();//添加完组件后，再写这句话
		this.setVisible(true);
	}
}
