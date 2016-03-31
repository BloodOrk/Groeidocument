package Java2D.Hoofdstuk2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe2_2 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 2.2");
		JPanel panel = new Excersise2();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe2_2() {

	}

}

class Excersise2 extends JPanel {

	public Excersise2() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);
		Color c;
		g2.drawLine(0, -getHeight() / 2, 0, getHeight() / 2);
		g2.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0);

		int x1 = 0;
		int y1 = 0;
		int x2;
		int y2;
		int nPoints = 500;

		for (int i = 0; i < nPoints; i++) {
			double t = i * 8 * Math.PI / nPoints;
			x2 = (int) (20 * t * Math.cos(t));
			y2 = (int) (20 * t * Math.sin(t));
			g2.drawLine(x1, y1, x2, y2);
			x1 = x2;
			y1 = y2;

			if (i < 500 && i > 400) {
				c = Color.red;
				g2.setColor(c);
			}

			if (i < 400 && i > 300) {
				c = Color.green;
				g2.setColor(c);
			}

			if (i < 300 && i > 200) {
				c = Color.blue;
				g2.setColor(c);
			}

			if (i < 200 && i > 100) {
				c = Color.magenta;
				g2.setColor(c);
			}

			if (i < 100 && i > 0) {
				c = Color.yellow;
				g2.setColor(c);
			}

		}

	}

}