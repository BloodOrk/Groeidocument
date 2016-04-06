package Java2D.Eindproject2D;


import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;

public class Main extends JFrame {
    public MainPanel panel;

    public static void main(String[] args) {

        new Timer(10, new ActionListener() {
            Main mP = new Main();

            public void actionPerformed(ActionEvent e) {

                if (mP.panel.flaresLeft() > -1) {
                    mP.repaint();
                }

            }
        }).start();
    }

    public Main() {

        super("2D Awesomeness");

        this.panel = new MainPanel();
        this.setBackground(Color.black);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
        });

    }

}

class MainPanel extends JPanel {

    private LinkedList<Flare> flares = new LinkedList<>();
    private Random rGen = new Random();

    public MainPanel() {

        setPreferredSize(new Dimension(800, 600));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    explosion(me.getX(), me.getY());
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton((me))) {
                    explosion(me.getX(), me.getY());
                }
            }
        });

    }

    public int flaresLeft() {
        return flares.size();
    }

    public boolean removeFlare(Flare f) {
        return this.flares.remove(f);
    }

    private void explosion(int x, int y) {

        int flareCount = 50 + rGen.nextInt(50);
        Color c = new Color(rGen.nextInt(255), rGen.nextInt(255), rGen.nextInt(255));
        long lifetime = 1000 + rGen.nextInt(1000);

        createFlare(x, y, c, flareCount, lifetime);

    }

    private void createFlare(int x, int y, Color c, int flareCount, long lifetime) {

        for (int i = 0; i < flareCount; i++) {

            double dir = 360 * rGen.nextDouble();
            double spd = 10 * rGen.nextDouble() + 5;
            flares.addLast(new Flare(this, dir, x, y, c, lifetime, spd));

        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponents(g);

        Graphics2D g2d = (Graphics2D) g;

        Flare arrayF[] = flares.toArray(new Flare[0]);

        for (Flare f : arrayF) {
            f.draw(g2d);
        }

    }

}