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
		//�м�������������º����ҿ���ȥ����
		//BorderLayout bl = new BorderLayout();//���캯������FlowLayout��ͬ��������������ʽ
		Button b1 = new Button("North");
		Button b2 = new Button("South");
		Button b3 = new Button("Center");
		Button b4 = new Button("East");
		Button b5 = new Button("West");
		//this.setLayout(bl);//��仰�����ǰ�棬��Ȼ�ź��治ͬ��λ�ã������ͬ�Ĵ���
		this.add(b1,BorderLayout.NORTH);
		//this.add(b2,BorderLayout.SOUTH);
		this.add(b3,BorderLayout.CENTER);
		//this.add(b4,BorderLayout.EAST);
		//this.add(b5,BorderLayout.WEST);
		//this.setLayout(bl);
		this.setSize(200,300);//�����ô�С������һ��
		this.setVisible(true);

		//this.setLayout(bl);
	}
}
