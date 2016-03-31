package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_07 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.7");
		JPanel panel = new Excersise7();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_07() {

	}

}

class Excersise7 extends JPanel {

	public Excersise7() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);
		g2.setColor(Color.cyan);

		Rectangle2D rect = new Rectangle2D.Double(-250, -250, 500, 500);
		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.toRadians(45.0));
		g2.transform(tx);
		g2.fill(rect);

	}

}
