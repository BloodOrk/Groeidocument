/*
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_0x {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.x");
		JPanel panel = new Excersisex();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_0x() {

	}

}

class Excersisex extends JPanel {

	public Excersisex() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);
		Color c;

	}

}
*/
