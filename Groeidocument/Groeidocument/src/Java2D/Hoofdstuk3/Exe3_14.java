package Java2D.Hoofdstuk3;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_14 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.14");
		JPanel panel = new Excersise14();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_14() {

	}

}

class Excersise14 extends JPanel {

	public Excersise14() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);

		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.toRadians(45));
		Font font = new Font("Serif", Font.BOLD, 50);
		font = font.deriveFont(tx);
		g2.setFont(font);
		g2.drawString("What Is Love?", -200, 150);
		tx.rotate(Math.toRadians(-90));
		font = font.deriveFont(tx);
		g2.setFont(font);
		g2.drawString("Baby Don't Hurt Me.", -150, 150);
		g2.drawString("Baby Don't Hurt Me.", -50, 250);
		tx.rotate(Math.toRadians(90));
		font = font.deriveFont(tx);
		g2.setFont(font);
		g2.drawString("No More.", 150, -200);

	}

}