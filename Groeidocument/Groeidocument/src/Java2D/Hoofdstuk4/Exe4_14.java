package Java2D.Hoofdstuk4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Calendar;

import javax.swing.*;

public class Exe4_14 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exercise 4.14");
        JPanel panel = new Excersise14();

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Exe4_14() {

    }

}

class Excersise14 extends JPanel implements ActionListener {

    AffineTransform rotH = new AffineTransform();
    AffineTransform rotM = new AffineTransform();
    AffineTransform rotS = new AffineTransform();

    public Excersise14() {

        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.white);
        Timer timer = new Timer(500, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        draw(g2);

    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.translate(320,320);

        Paint paint = new GradientPaint(-150,-150,Color.white,150,150,Color.blue);
        g2.setRenderingHints(rh);
        g2.setPaint(paint);
        g2.fillOval(-190, -190, 380, 380);
        g2.setColor(Color.black);
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
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.draw(hour);
        g2.draw(minute);
        g2.setStroke(new BasicStroke(2));
        g2.draw(second);
    }

    public void actionPerformed(ActionEvent e) {
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int min = Calendar.getInstance().get(Calendar.MINUTE);
        int sec = Calendar.getInstance().get(Calendar.SECOND);
        rotH.setToRotation(Math.PI * (hour+min/60.0)/6.0);
        rotM.setToRotation(Math.PI * min /30.0);
        rotS.setToRotation(Math.PI * sec /30.0);
        repaint();
    }

}
