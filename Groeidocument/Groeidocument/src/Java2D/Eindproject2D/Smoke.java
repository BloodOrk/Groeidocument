package Java2D.Eindproject2D;


import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Smoke {

    private double opacity;
    private double dirX;
    private double dirY;
    private double spd;
    private int x;
    private int y;
    private Color c;
    private long lifetime;
    private long spawntime;
    private MainPanel parent;
    private Ellipse2D.Double smoke;

    public Smoke(MainPanel parent, double dirX, double dirY, int x, int y, Color c, long lifetime, double spd) {

        this.parent = parent;
        this.dirX = dirX;
        this.dirY = dirY;
        this.x = x;
        this.y = y;
        this.c = this.getColor();
        this.lifetime = lifetime;
        this.spd = spd;
        opacity = 255;

    }

    public void step() {

    }

    public Color getColor() {

        if (opacity < 0) {
            return new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) opacity);
        }
        return new Color(0, 0, 0, 0);

    }

    public void draw(Graphics2D g2d){

    }

}
