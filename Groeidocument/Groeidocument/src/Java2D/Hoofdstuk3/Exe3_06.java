package Java2D.Hoofdstuk3;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_06 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.6");
		JPanel panel = new Excersise6();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_06() {

	}

}

class Excersise6 extends JPanel {

	public Excersise6() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);

		Polygon pentagon = new Polygon();

		int x = 150;
		int y = 100;
		int r = 100;
		BasicStroke bs = new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND, 0);

		for (int i = 0; i < 5; i++) {
			pentagon.addPoint((int) (x + r * Math.cos(i * 2 * Math.PI / 5)),
					(int) (y + r * Math.sin(i * 2 * Math.PI / 5)));
		}

		g2.setStroke(bs);
		g2.drawPolygon(pentagon);

	}

}
