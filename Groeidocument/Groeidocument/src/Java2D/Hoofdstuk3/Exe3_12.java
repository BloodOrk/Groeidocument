package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_12 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.12");
		JPanel panel = new Excersise12();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_12() {

	}

}

class Excersise12 extends JPanel {

	public Excersise12() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2 - 250, getHeight() / 2 + 250);
		g2.scale(1, -1);

		Area square = new Area(new Rectangle(500, 500));
		square.subtract(new Area(new Ellipse2D.Double(125, 125, 250, 250)));
		g2.setColor(Color.green);
		g2.fill(square);
		g2.setColor(Color.black);
		g2.draw(square);
		g2.setClip(square);
		g2.scale(1, -1);
		g2.setFont(new Font("Serif", Font.BOLD, (int) 135));
		g2.drawString("Java 2D", 10, 0);
		g2.drawString("Java 2D", 10, -100);
		g2.drawString("Java 2D", 10, -200);
		g2.drawString("Java 2D", 10, -300);
		g2.drawString("Java 2D", 10, -400);

	}

}
