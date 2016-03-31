package Java2D.Hoofdstuk3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_01 {

	// PixelArt voor een beter voorbeeld

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.1");
		JPanel panel = new Excersise01();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_01() {

	}

}

class Excersise01 extends JPanel {

	public Excersise01() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.scale(1, -1);

		g2.fillRect(0, 0, 50, 50);
		g2.setColor(Color.blue);
		g2.fillRect(0, 50, 50, 50);
		g2.setColor(Color.cyan);
		g2.fillRect(50, 0, 50, 50);
		g2.setColor(Color.darkGray);
		g2.fillRect(-50, 0, 50, 50);
		g2.setColor(Color.gray);
		g2.fillRect(0, -50, 50, 50);
		g2.setColor(Color.green);
		g2.fillRect(-50, -50, 50, 50);
		g2.setColor(Color.lightGray);
		g2.fillRect(50, -50, 50, 50);
		g2.setColor(Color.magenta);
		g2.fillRect(-50, 50, 50, 50);
		g2.setColor(Color.orange);
		g2.fillRect(50, 50, 50, 50);
		g2.setColor(Color.pink);
		g2.fillRect(0, 100, 50, 50);
		g2.setColor(Color.red);
		g2.fillRect(100, 0, 50, 50);
		g2.setColor(Color.white);
		g2.fillRect(-100, 0, 50, 50);
		g2.setColor(Color.yellow);
		g2.fillRect(0, -100, 50, 50);

	}

}
