package test.gui;
import java.awt.*;
public class TestBordLayout
{

	public static void main(String[] args)
	{
		MyFrame4 f = new MyFrame4();

	}

}

class MyFrame4 extends Frame
{
	MyFrame4()
	{
		//中间会留出来，上下和左右可以去掉的
		//BorderLayout bl = new BorderLayout();//构造函数，和FlowLayout不同，不带参数的形式
		Button b1 = new Button("North");
		Button b2 = new Button("South");
		Button b3 = new Button("Center");
		Button b4 = new Button("East");
		Button b5 = new Button("West");
		//this.setLayout(bl);//这句话必须放前面，不然放后面不同的位置，会出不同的错误
		this.add(b1,BorderLayout.NORTH);
		//this.add(b2,BorderLayout.SOUTH);
		this.add(b3,BorderLayout.CENTER);
		//this.add(b4,BorderLayout.EAST);
		//this.add(b5,BorderLayout.WEST);
		//this.setLayout(bl);
		this.setSize(200,300);//不设置大小就缩成一团
		this.setVisible(true);

		//this.setLayout(bl);
	}
}
