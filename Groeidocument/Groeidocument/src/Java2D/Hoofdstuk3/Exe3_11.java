package Java2D.Hoofdstuk3;

import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_11 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.11");
		JPanel panel = new Excersise11();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_11() {

	}

}

class Excersise11 extends JPanel {

	public Excersise11() {
	setPreferredSize(new Dimension(400,400));
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		AffineTransform tx = new AffineTransform(0,1,1,0,0,0);

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.drawLine(0, -getHeight() / 2, 0, getHeight() / 2);
		g2.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0);
		g2.setColor(Color.green);
		g2.drawLine(-getWidth()/2, getHeight()/2, getWidth()/2, -getHeight()/2);
		g2.scale(1, -1);
		g2.setColor(Color.red);
		g2.drawRect(-50, -50, 100, 100);

		g2.scale(3, 3);
		g2.transform(tx);
		g2.setColor(Color.blue);
		g2.drawRect(-50, -50, 100, 100);
	}

}