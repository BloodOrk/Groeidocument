
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class BareMinimum {

	public static void main(String s[])
	{
		JFrame frame = new JFrame("Hello World 2D");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new BareMinimumPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}	
}

class BareMinimumPanel extends JPanel
{
	// member variables
	private int cnt = 0;
	
	// Constructor
	public BareMinimumPanel()
	{
		setPreferredSize( new Dimension(640,480) );
	}
	
	// Super important, override paintComponents
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		System.out.println("Refresh by VM: " + cnt );
		cnt++;
	}
}


