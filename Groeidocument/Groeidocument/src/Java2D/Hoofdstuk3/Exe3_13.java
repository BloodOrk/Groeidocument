package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_13 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.13");
		JPanel panel = new Excersise13();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_13() {

	}

}

class Excersise13 extends JPanel {

	BufferedImage img = null;

	public Excersise13() {

		try {
			img = ImageIO.read(new File("src/Images/strawberry.jpg"));
		} catch (IOException e) {
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);
		Area square = new Area(new Rectangle(500, 500));
		square.subtract(new Area(new Ellipse2D.Double(125, 125, 250, 250)));
		Area ellipse = new Area(new Ellipse2D.Double(125, 125, 250, 250));
		g2.translate(-250, -250);
		g2.setColor(Color.black);
		g2.fill(square);
		g2.draw(square);
		g2.setClip(ellipse);
		g2.translate(250, 250);
		g2.scale(2, -2);
		g2.drawImage(img, null, -160, -150);

	}

}
