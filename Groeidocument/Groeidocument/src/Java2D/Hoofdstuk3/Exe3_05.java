package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_05 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.5");
		JPanel panel = new Excersise5();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_05() {

	}

}

class Excersise5 extends JPanel {

	Color c;

	public Excersise5() {

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				c = JColorChooser.showDialog(null, "Pick a Color", c);
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2 - 250, getHeight() / 2 + 250);
		g2.scale(1, -1);

		Area square = new Area(new Rectangle(500, 500));
		square.subtract(new Area(new Ellipse2D.Double(125, 125, 250, 250)));
		g2.setColor(c);
		g2.fill(square);
		g2.setColor(Color.black);
		g2.draw(square);

	}

}
