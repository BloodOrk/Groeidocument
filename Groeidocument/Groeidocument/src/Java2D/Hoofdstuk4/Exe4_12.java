package Java2D.Hoofdstuk4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.*;

public class Exe4_12 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exercise 4.12");
        JPanel panel = new Excersise12();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Exe4_12() {

    }

}

class Excersise12 extends JPanel implements ActionListener {

    AffineTransform rotH = new AffineTransform();
    AffineTransform rotM = new AffineTransform();
    AffineTransform rotS = new AffineTransform();
    Timer timer = new Timer(100, this);
    int mode = 0;
    int hour;
    int min;
    int sec;
    int tsec;

    public Excersise12() {

        setPreferredSize(new Dimension(480, 480));
        setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ev) {
                switch (mode) {
                    case 0:
                        timer.start();
                        break;
                    case 1:
                        timer.stop();
                        break;
                    case 2:
                        hour = min = sec = tsec = 0;
                        rotH.setToIdentity();
                        rotM.setToIdentity();
                        rotS.setToIdentity();
                        break;
                }

                mode = (mode + 1) % 3;
                repaint();
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(getWidth() / 2, getHeight() / 2);

        Paint paint = new GradientPaint(-150,-150,Color.white,150,150,Color.red);
        g2.setPaint(paint);
        g2.fillOval(-190, -190, 380, 380);
        g2.setColor(Color.black);
        g2.drawString("Stopwatch", -25, 60);
        g2.drawString("mode: " + mode, -20, 80);
        g2.drawString("Time: " + hour + " " + min + " " + sec, -30, 100);
        Stroke stroke = new BasicStroke(3);
        g2.setStroke(stroke);
        g2.drawOval(-190, -190, 380, 380);

        for (int i = 0; i < 12; i++) {
            g2.rotate(2*Math.PI/12);
            g2.fill3DRect(-3, -180, 6, 30, true);
        }

        Shape hour = new Line2D.Double(0, 0, 0, -80);
        hour = rotH.createTransformedShape(hour);
        Shape minute = new Line2D.Double(0, 0, 0, -120);
        minute = rotM.createTransformedShape(minute);
        Shape second = new Line2D.Double(0, 0, 0, -120);
        second = rotS.createTransformedShape(second);

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(hour);
        g2.draw(minute);
        g2.setStroke(new BasicStroke(2));
        g2.draw(second);

    }

    public void actionPerformed(ActionEvent e) {
        tsec++;
        if (tsec >= 10) {
            tsec = 0;
            sec++;
            if (sec >= 60) {
                sec = 0;
                min++;
                if (min >= 60) {
                    min = 0;
                    hour++;
                }
            }
        }
        rotH.setToRotation(Math.PI * (hour+min/60.0)/6.0);
        rotM.setToRotation(Math.PI * (min + sec/60.0) /30.0);
        rotS.setToRotation(Math.PI * (sec + 0.1*tsec) /30.0);
        repaint();
    }

}
