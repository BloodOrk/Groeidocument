package Java2D.Hoofdstuk4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Exe4_10 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exercise 4.10");
        JPanel panel = new Excersise10();
        frame.getContentPane().add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Excersise10 extends JPanel implements ActionListener{

    int angle = 0;

    public Excersise10() {

        setPreferredSize(new Dimension(400,400));
        setBackground(Color.white);
        Timer timer = new Timer(10, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int xCenter = getSize().width / 2;
        int yCenter = getSize().height / 2;
        int radius = (int) (Math.min(xCenter, yCenter)*0.8)-10;
        int x = xCenter - radius;
        int y = yCenter - radius;

        g2.drawOval(x - 10, y - 10, 2 * radius + 20, 2 * radius + 20);
        g2.setColor(Color.red);
        g2.fillArc(x, y, 2 * radius, 2 * radius, angle, 30);
        g2.fillArc(x, y, 2 * radius, 2 * radius, angle + 90, 30);
        g2.fillArc(x, y, 2 * radius, 2 * radius, angle + 180, 30);
        g2.fillArc(x, y, 2 * radius, 2 * radius, angle + 270, 30);

    }

    public void actionPerformed(ActionEvent e){

        angle += 2;
        if(angle > 360) {
            angle -= 360;
        }
        repaint();
    }

}
