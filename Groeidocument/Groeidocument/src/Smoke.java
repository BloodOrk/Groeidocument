import java.awt.Color;

public class Smoke {

	double x, y, a;
	int shapePicker;
	private Color color;
	private double dirX, dirY, dislvSpd;

	/**
	 * x and y are the locations dirX is the x direction dirY the other one
	 * dislvSpd is the speed at witch this one disappears
	 */
	public Smoke(int x, int y, double dirX, double dirY, double dislvSpd, Color color, int shapePicker, int dif) {
		this.x = x;
		this.y = y;
		this.dirX = dirX - dif/2;
		this.dirY = dirY - dif/2;
		this.dislvSpd = dislvSpd;
		this.color = color;
		this.shapePicker = shapePicker;
		a = 255;
	}

	public void update() {
		x += dirX;
		y += dirY;
		a -= dislvSpd;
	}

	public Color getColor() {
		if (a > 0)
			return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) a);
		return new Color(0, 0, 0, 0);
	}
}
