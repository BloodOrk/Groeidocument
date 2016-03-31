package Java2D.Hoofdstuk3;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe3_15 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Exercise 3.15");
		JPanel panel = new Excersise15();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Exe3_15() {

	}

}

class Excersise15 extends JPanel {

	public Excersise15() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.translate(getWidth() / 2, getHeight() / 2);
		Font font = new Font("Serif", Font.BOLD, 200);
		FontRenderContext frc = g2.getFontRenderContext();
		GlyphVector gvN = font.createGlyphVector(frc, "N");
		GlyphVector gvY = font.createGlyphVector(frc, "Y");
		Shape glyphN = gvN.getOutline(-75, 75);
		Shape glyphY = gvY.getOutline(-75, 75);
		g2.draw(glyphN);
		g2.setColor(Color.red);
		g2.draw(glyphY);

	}

}
