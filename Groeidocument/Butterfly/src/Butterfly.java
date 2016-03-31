import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Butterfly {
	
	public static void main(String s[])
	{
		JFrame frame = new JFrame("Hoofdstuk 2 - Butterfly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new ButterflyPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}


class ButterflyPanel extends JPanel { 
	
	public ButterflyPanel()
	{
		setPreferredSize( new Dimension(800,600));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		// 0-punt verlegging
		// Invert de Y-as en verschuif middelpunt naar midden van scherm
//		g2.translate(0,getHeight());
//		g2.scale(1,-1);
//		
//		// Center screen
//		g2.translate(getWidth()/2, getHeight()/2);
//		g2.scale(1, 1);
				
		// 
		//
		double xold = 0, yold = 0;
		double amplitude = 40.0;
		
		for( int tt = 0; tt < 10000; tt++)
		{
			double t = tt * Math.PI / 180;
			
			double c = (Math.exp(Math.cos(t)) - 2.0*Math.cos(4.0*t) - Math.pow(Math.sin(t/12.0),5.0));
			double x = amplitude * Math.sin(t) * c;
			double y = amplitude * Math.cos(t) * c;
			
			g2.drawLine((int)xold,(int)yold,(int)x,(int)y);
			
			xold = x;
			yold = y;
		}
	}
}
