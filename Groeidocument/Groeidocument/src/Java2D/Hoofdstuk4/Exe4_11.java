package Java2D.Hoofdstuk4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Area;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Exe4_11 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exercise 4.11");
        JPanel panel = new Excersise11();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Exe4_11() {

    }

}

class Excersise11 extends JPanel implements ActionListener {

    Timer t = new Timer(5, this);
    double x = -15;
    double y = -15;
    double randomX = Math.cos(Math.random() * 2 * Math.PI);
    double randomY = Math.sin(Math.random() * 2 * Math.PI);
    double xVel =  (int) (3 * randomX);
    double yVel = (int) (3 * randomY);

    int xWall = 300;
    int yWall = 300;
    int offset = 35;

    public Excersise11() {

        t.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        g2.translate(xCenter, yCenter);
        g2.scale(1, -1);

        Rectangle2D rect = new Rectangle2D.Double(-300, -300, 600, 600);
        g2.setColor(Color.blue);
        g2.draw(rect);
        Ellipse2D oval = new Ellipse2D.Double(x, y, 30, 30);
        g2.setColor(Color.green);
        g2.fill(oval);

    }

    public void bounce(){

        randomX = Math.cos(Math.random() * 2 * Math.PI);
        randomY = Math.sin(Math.random() * 2 * Math.PI);
        double speed = 3;

        //Right
        if(x >= 0 && x <= xWall) {
            xVel = (int) -(speed * randomX);
            //Top
            if (y >= 0 && y <= yWall){
                yVel = (int) (speed * randomY);
            }
            //Bottom
            if(y < 0 && y >= -yWall){
                yVel = (int) (speed * randomY);
            }
        }
        //Left
        else if(x <= 0 && x >= -xWall) {
            xVel = (int) (speed * randomX);
            //Top
            if (y >= 0 && y >= yWall){
                yVel = (int) (speed * randomY);
            }
            //Bottom
            if(y < 0 && y >= -yWall){
                yVel = (int) (speed * randomY);
            }
        }

    }

    public void actionPerformed(ActionEvent e){

        x += xVel;
        y += yVel;

        if(x >= xWall){

            x = xWall - offset;
            bounce();

        }
        if(x <= -xWall){

            x = -xWall + offset;
            bounce();

        }
        if(y >= yWall){

            y = yWall - offset;
            bounce();

        }
        if(y <= -yWall){

            y = -yWall + offset;
            bounce();

        }

        repaint();

    }

}
