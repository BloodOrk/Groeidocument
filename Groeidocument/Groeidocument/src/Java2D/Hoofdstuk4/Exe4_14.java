package Java2D.Hoofdstuk4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exe4_14 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exercise 4.14");
        JPanel panel = new Excersise14();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Exe4_14() {

    }

}

class Excersise14 extends JPanel {

    public Excersise14() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.scale(1, -1);

    }

}
