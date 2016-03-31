package Java2D.Hoofdstuk2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe2_3 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 2.3");
		JPanel panel = new Excersise3();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe2_3() {

	}

}

class Excersise3 extends JPanel {

	public Excersise3() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D g3 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);
		Color c;
		g2.drawLine(0, -getHeight() / 2, 0, getHeight() / 2);
		g2.drawLine(-getWidth() / 2, 0, getWidth() / 2, 0);

		c = Color.red;
		g3.setColor(c);
		g3.rotate(Math.PI / 4);
		g3.drawRect(-50, -50, 100, 100);

	}

}
