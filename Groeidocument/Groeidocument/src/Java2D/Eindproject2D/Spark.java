package Java2D.Eindproject2D;

import java.awt.*;
import java.awt.geom.*;

public class Spark implements Flare{

    private double dir;
    private double spd;
    private double acc;
    private int x;
    private int y;
    private Color c;
    private long lifetime;
    private long spawntime;
    private FireworksPanel parent;
    private int radius = 5;
    private int diameter = radius * 2;
    private Ellipse2D.Double spark;

    public Spark(FireworksPanel parent, double dir, int x, int y, Color c, long lifetime, double spd){

        this.dir = dir;
        this.spd = spd;
        this.acc = -1.0 / lifetime * spd * 1.1;
        this.x = x - radius;
        this.y = y - radius;
        this.c = c;
        this.lifetime = lifetime;
        this.parent = parent;
        this.spawntime = System.currentTimeMillis();
        this.spark = new Ellipse2D.Double(0, 0, diameter, diameter);

    }

    public void step(){

        long currentTime = System.currentTimeMillis();
        long currentLifeTime = currentTime - spawntime;

        if ( currentLifeTime < lifetime) {

            double currentSpeed = spd + acc * currentLifeTime;

            double dx = currentSpeed * Math.cos(Math.toRadians(dir));
            double dy = currentSpeed * Math.sin(Math.toRadians(dir));

            spark.x += dx;
            spark.y += dy;

            double shrink = 1 - ((double)currentLifeTime / lifetime);

            spark.height = diameter * shrink;
            spark.width  = diameter * shrink;
        } else {
            if (parent.flaresLeft() == 1) {
                parent.repaint();
            }
            parent.removeFlare(this);
        }

    }

    public void draw(Graphics2D g2d){

        step();

        g2d.setColor(c);

        double loops = 70;
        for (int i = (int)loops; i > 0; i--) {
            double scale = ((double)i) / loops;
            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            at.scale(scale, scale);

            Color newColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), Math.min((int)Math.round(255 * (1/scale)), 255));

            g2d.setColor(newColor);
            g2d.fill(at.createTransformedShape(spark));
        }

    }

}
