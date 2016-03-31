package Java2D.Hoofdstuk2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe2_1 extends JFrame {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 2.1");
		JPanel panel = new Excersise1();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

class Excersise1 extends JPanel {

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
		int nPoint = 400;

		c = Color.red;
		g2.setColor(c);

		for (double i = 0; i < nPoint; i += 0.01) {

			x2 = (int) (100 * Math.pow(i, 2));
			y2 = (int) (100 * Math.pow(i, 3));

			g2.drawLine(x1, y1, x2, y2);

			x1 = x2;
			y1 = y2;

		}
	}
}
