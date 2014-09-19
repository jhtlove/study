package test.gui;
import java.awt.*;
import java.awt.event.*;

public class KeyEvent1
{

	public static void main(String[] args)
	{
		MyFrame0 f = new MyFrame0();
		f.launchFrame();

	}

}
class MyFrame0 extends Frame
{
	Button b = new Button("Start");
	
	TextField t = new TextField();
	public void launchFrame()
	{

		b.addActionListener(new ActionListener(){
			private int i = 0;

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				t.setText("start" + ++i);
				
			}
			
		});
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);
				System.exit(0);
			}
		});
		this.setLayout(new BorderLayout());
		this.add(b,BorderLayout.NORTH);
		this.add(t,BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	
}