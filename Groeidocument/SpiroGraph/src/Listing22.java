
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Listing22 {
	
	public static void main(String s[])
	{
		JFrame frame = new JFrame("Hoofdstuk 2 - Spirograph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new SpiroPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}


class SpiroPanel extends JPanel {

	double a, b, x0, y0;
	int hoek;
	
	public SpiroPanel()
	{
		setPreferredSize( new Dimension(640,480));
		setBackground(Color.black);
		
		a = 150;
		b = 75;
		x0 = 320;
		y0 = 240;
		hoek = 280;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.red);
		
		int xnew = 0, ynew = 0;
		int xold = 0, yold = 0;
		
		// idx van 0 tot aan aantal te tekenen punten
		for( double t = 0; t < hoek; t++)
		{
			// t van hoek in graden naar radialen.
			double angleRad = t * Math.PI / 180;
			
			// Bereken nu x(t) en y(t) en trek lijn tussen vorige en nieuwe
			// waarde.
			xnew = (int) (x0 + a * Math.cos(angleRad));
			ynew = (int) (y0 + b * Math.sin(angleRad));
			
			g2.drawLine(xold,yold,xnew,ynew);
		
			// Overschrijf de oude met de nieuwe waarde.
			xold = xnew;
			yold = ynew;
		}
	}
}

