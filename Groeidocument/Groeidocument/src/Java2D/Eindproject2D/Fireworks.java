package Java2D.Eindproject2D;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;

public class Fireworks extends JFrame{

    public FireworksPanel panel;

    public static void main(String[] args) {

        new Timer(33, new ActionListener() {
            Fireworks f = new Fireworks();

            public void actionPerformed(ActionEvent e) {

                if (f.panel.flaresLeft() > 0) {
                    f.repaint();
                }

            }
        }).start();

        }

    public Fireworks(){

        super();

        this.panel = new FireworksPanel();
        this.setBackground(Color.black);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);

    }

}

class FireworksPanel extends JPanel {

    private LinkedList<Flare> flares = new LinkedList<>();
    private Random rGen = new Random();

    public FireworksPanel(){

        setPreferredSize(new Dimension(800, 600));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton((me))) {
                    explosion(me.getX(), me.getY());
                }
            }
        });

    }

    public int flaresLeft(){
        return flares.size();
    }

    public boolean removeFlare(Flare f){
        return this.flares.remove(f);
    }

    private void explosion(int x, int y){

        int flareCount = 50 + rGen.nextInt(20);
        Color c = new Color(rGen.nextInt(255), rGen.nextInt(255), rGen.nextInt(255));
        long lifetime = 1000 + rGen.nextInt(1000);

        createFlare(x, y, c, flareCount, lifetime);

    }

    private void createFlare(int x, int y, Color c, int flareCount, long lifetime){

        for(int i = 0; i < flareCount; i++){

            double dir = 360 * rGen.nextDouble();
            double spd = 10 * rGen.nextDouble() + 5;
            flares.addLast(new Spark(this, dir, x, y, c, lifetime, spd));

        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        Graphics2D g2d = (Graphics2D)g;

        Flare array[] = flares.toArray(new Flare[0]);

        for(Flare f : array){
            f.draw(g2d);
        }

    }

}

