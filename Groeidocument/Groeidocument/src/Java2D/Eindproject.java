package Java2D;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Eindproject {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Eindproject 2D Myk Pieren");
        JPanel panel = new EindProjectFrame();

        frame.setBackground(Color.black);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Eindproject() {

    }

}

class EindProjectFrame extends JPanel{

    private Random rGen = new Random();
    private ArrayList<Sparks> sparks = new ArrayList<>();

    public EindProjectFrame(){

        setPreferredSize(new Dimension(800, 600));

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ev) {
                System.out.println("Fireworks yay");
                FireworkExplosion(ev.getX(), ev.getY());
            }
        });

    }

    public void FireworkExplosion(int x, int y){

        int projectileCount = 50 + rGen.nextInt(50);
        Color c = new Color(rGen.nextInt(255), rGen.nextInt(255), rGen.nextInt(255));
        int lifeTime = 1000 + rGen.nextInt(1000);

        createSpark(x, y, c, projectileCount, lifeTime);

    }

    public void createSpark(int x, int y, Color c, int projectileCount, int lifeTime){

        for(int i = 0; i < lifeTime; i++){
            double dir = 360 * rGen.nextDouble();
            double spd = 10 * rGen.nextDouble() + 5;

            sparks.add(new Sparks());

        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.scale(1, -1);


    }

}
class Sparks{

    public interface Spark{

        void draw(Graphics2D g);

    }

}
