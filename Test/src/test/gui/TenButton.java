package test.gui;
import java.awt.*;
public class TenButton
{

	public static void main(String[] args)
	{
		Frame f = new Frame("Ten Button");
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridheight = 2;//占用两行网格
		c1.gridwidth = 1;
		c1.weightx = 1;//权重，第一行，第一列设置好比例就可以了，最外层网格的缩放就定了，其余的可以fill both水平和竖直
		c1.weighty = 1;
		//c1.gridx = 0;
		//c1.gridy = 0;
		c1.fill = GridBagConstraints.BOTH;
		//c1.weightx = 1;
		Button button1 = new Button("button1");
        gbl.setConstraints(button1, c1);
        f.add(button1);
        
		
		
		//Panel p1 = new Panel();//前面占了2行，这里不用Panel直接添加两个Button
		//p1.setLayout(new GridLayout(2,1));
		//p1.add(new Button("button2"));
		//p1.add(new Button("button3"));
		GridBagConstraints c2 = new GridBagConstraints();
		//c2.gridheight = GridBagConstraints.REMAINDER; 从 gridx 到 最后
		c2.gridheight = 1;
		c2.gridwidth = 1;
		c2.weightx = 5;
		c2.weighty = 1;
		//c2.gridwidth = GridBagConstraints.RELATIVE;
		//c2.gridx = 1;
		//c2.gridy = 0;
		c2.fill = GridBagConstraints.BOTH;
		Button button2 = new Button("button2");
		Button button3 = new Button("button3");
		gbl.setConstraints(button2, c2);
		f.add(button2);
		
		
		c2.gridx = 1;//默认从左到右，所以这里如果要先放好，必须指定防止的单元格坐标
		c2.gridy = 1;
		c2.weightx = 0;
		c2.weighty = 0;
		gbl.setConstraints(button3, c2);
		f.add(button3);
		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridheight = 2;
		c3.gridwidth = GridBagConstraints.REMAINDER;//end row
		//c3.weightx = 1;
		//c3.weighty = 1;
		c3.gridx = 2;
		c3.gridy = 0;//位于第一行，占两列，占的网格有（2，0）和（2，1），但是还是指定放置位置为（2,0)
		c3.fill = GridBagConstraints.BOTH;
		Button button4 = new Button("button4");
        gbl.setConstraints(button4, c3);
        f.add(button4);
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridheight = 1;
		c4.gridwidth = 1;
		c4.weightx = 1;
		c4.weighty = 5;
		c4.gridx = 0;//由于前面用了 GridBagconstraints.REMAINDER 占满了第一行，所以再添加会到第二行。
		c4.gridy = 2;
		c4.fill = GridBagConstraints.BOTH;
		Button button5 = new Button("button5");
        gbl.setConstraints(button5, c4);
        f.add(button5);
        
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(2,2));
		for(int i=0;i<4;i++)
		{
			p2.add(new Button("Button" + (i+6)));
		}
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridheight = 1;
		c5.gridwidth = GridBagConstraints.RELATIVE;
		//c5.weightx = 5;
		//c5.weighty = 5;
		c5.gridx = 1;
		c5.gridy = 2;
		c5.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(p2, c5);
		f.add(p2);
		
		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridheight = 1;
		c6.gridwidth = 1;
		//c6.weightx = 1;
		//c6.weighty = 5;
		c6.gridx = 2;
		c6.gridy = 2;
		c6.fill = GridBagConstraints.BOTH;
		Button button10 = new Button("button10");
        gbl.setConstraints(button10, c6);
        f.add(button10);
	
		f.setLayout(gbl );
		f.pack();
		//f.setResizable(false);
		//f.setSize(300,300);
		f.setVisible(true);

	}

}
