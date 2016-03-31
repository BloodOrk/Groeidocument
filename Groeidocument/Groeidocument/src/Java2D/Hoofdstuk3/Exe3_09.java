package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_09 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.9");
		JPanel panel = new Excersise9();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_09() {

	}

}

class Excersise9 extends JPanel {

	public Excersise9() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		AffineTransform tx = new AffineTransform();

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);
		g2.drawLine(0, -getHeight() / 2, 0, getHeight() / 2);
		g2.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0);
		g2.drawLine(-getWidth() / 2, -getHeight(), getWidth() / 2, getHeight());

		g2.fillRect(0, 0, 100, 50);

		tx.translate(0, 2 * -50);
		tx.translate(-100, 0);
		tx.rotate(Math.toRadians(90));
		tx.translate(-100, 2 * -50);

		g2.transform(tx);
		g2.setColor(Color.blue);
		g2.fillRect(0, 0, 100, 50);

	}

}
