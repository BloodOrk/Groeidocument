package Java2D.Hoofdstuk3;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_10 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.10");
		JPanel panel = new Excersise10();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_10() {

	}

}

class Excersise10 extends JPanel {

	public Excersise10() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.drawLine(0, -getHeight() / 2, 0, getHeight() / 2);
		g2.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0);

		AffineTransform tx = new AffineTransform();
		tx.rotate(-Math.toRadians(360 / 17));
		Font font = new Font("Serif", Font.BOLD, 120);
		g2.setFont(font);
		int y = 500;
		int x = 0;

		g2.drawString("J", x, y);
		g2.transform(tx);
		g2.drawString("A", x, y);
		g2.transform(tx);
		g2.drawString("V", x, y);
		g2.transform(tx);
		g2.drawString("A", x, y);
		g2.transform(tx);
		g2.drawString(" ", x, y);
		g2.transform(tx);
		g2.drawString("2", x, y);
		g2.transform(tx);
		g2.drawString("D", x, y);
		g2.transform(tx);
		g2.drawString(" ", x, y);
		g2.transform(tx);
		g2.drawString("G", x, y);
		g2.transform(tx);
		g2.drawString("R", x, y);
		g2.transform(tx);
		g2.drawString("A", x, y);
		g2.transform(tx);
		g2.drawString("P", x, y);
		g2.transform(tx);
		g2.drawString("H", x, y);
		g2.transform(tx);
		g2.drawString("I", x, y);
		g2.transform(tx);
		g2.drawString("C", x, y);
		g2.transform(tx);
		g2.drawString("S", x, y);
		g2.transform(tx);
		g2.drawString(" ", x, y);
		g2.transform(tx);

	}

}
