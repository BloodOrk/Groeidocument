package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_03 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.3");
		JPanel panel = new Excersise3();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_03() {

	}

}

class Excersise3 extends JPanel {

	public Excersise3() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);

		Color c1 = new Color(0, 0, 0);
		Color c2 = new Color(1f, 1f, 1f);

		GradientPaint gp = new GradientPaint(-500, -125, c1, 250, 125, c2);

		Shape r = new Rectangle2D.Double(-250, -250, 500, 500);
		Shape o = new Ellipse2D.Double(-125, -125, 250, 250);

		g2.setPaint(gp);
		Area a = new Area(r);
		a.subtract(new Area(o));
		g2.fill(a);

	}

}
