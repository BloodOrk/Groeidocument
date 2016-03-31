import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class HelloWorld2D {

	public static void main(String s[])
	{
		JFrame frame = new JFrame("Hello World 2D");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new HelloWorld2DPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}	
}

class HelloWorld2DPanel extends JPanel
{
	private int x = 0;
	
	public HelloWorld2DPanel()
	{
		setPreferredSize( new Dimension(640,480) );
	}
	
	public void paintComponent(Graphics g)
	{
		x++;
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.blue);
		Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 100);
		g2.draw(e);
		
		g2.setColor(Color.red);
		Ellipse2D e1 = new Ellipse2D.Double(-100, -50, 400, 300);
		g2.draw(e1);
		
		AffineTransform tr = new AffineTransform();
		tr.rotate(Math.PI / 6.0);
		Shape s = tr.createTransformedShape(e);
		
		g2.draw(s);
		
		g2.translate(300, 200);
	
		g2.draw(s);
		
		g2.drawString("Hello 2d "+x, 0, 0);
	}
}


