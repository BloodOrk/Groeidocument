import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class EasyGrapics extends JPanel {

	public static void main(String[] args) {
		Frame frame = new Frame("Intresting");
		frame.add(new EasyGrapics());
		frame.setVisible(true);
		frame.setBounds(100, 100, 300, 300);
		frame.setFocusable(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}

		});
	}

	private Smoke[] smoke;
	private boolean[] filledSmokes;
	private final int amount = 10000;

	private int mouseX, mouseY;
	private Timer timer;

	private int smoeksies = 0;

	public EasyGrapics() {
		smoke = new Smoke[amount];
		filledSmokes = new boolean[amount];
		setBackground(Color.black);

		new Timer(25, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}

		}).start();

		addMouseListener(new MouseAdapter() {
			private ArrayList<Timer> timers = new ArrayList<Timer>();

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isShiftDown()) {
					timers.add(new Timer(1, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e2) {
							if (Math.random() * 4 > 3)
								makeShapeOne(e.getX(), e.getY(), standardCheck());
						}
					}));
					timers.get(timers.size() - 1).start();
				} else if (e.isAltDown())
					for (int i = 0; i < timers.size(); i++) {
						timers.get(0).stop();
						timers.remove(0);
					}

				else {
					mouseX = e.getX();
					mouseY = e.getY();
					timer = new Timer(1, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e2) {
							makeShapeTwo(mouseX, mouseY, standardCheck());
							makeShapeTwo(mouseX, mouseY, standardCheck());
							makeShapeTwo(mouseX, mouseY, standardCheck());
							makeShapeTwo(mouseX, mouseY, standardCheck());
						}
					});
					timer.start();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (timer != null)
					if (timer.isRunning())
						timer.stop();

			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				smoeksies += e.getWheelRotation();

			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		for (int i = 0; i < amount; i++) {
			if (!filledSmokes[i])
				continue;
			if (smoke[i].a <= 0) {
				filledSmokes[i] = false;
				smoke[i] = null;
				continue;
			}
			g2d.setColor(smoke[i].getColor());
			g2d.fill(shapePicker(i));
			smoke[i].update();
		}
	}

	private Shape shapePicker(int counter) {
		if (smoke[counter].shapePicker == 0)
			return new Ellipse2D.Double(smoke[counter].x - 5, smoke[counter].y - 5, 10, 10);
		else if (smoke[counter].shapePicker == 1)
			return new Ellipse2D.Double(smoke[counter].x - 15 -smoeksies/2 , smoke[counter].y - 15-smoeksies/2,
					30 + smoeksies, 30 + smoeksies);
		else
			return null;
	}

	int standardCheck() {
		int counter = 0;
		while (filledSmokes[counter]) {
			counter++;
			if (counter == amount) {
				counter = 0;
				return -1;
			}
		}
		filledSmokes[counter] = true;
		return counter;
	}

	void makeShapeOne(int x, int y, int counter) {
		if (counter == -1)
			return;
		smoke[counter] = new Smoke(x, y, Math.random() * 2, Math.random() * 2, 2 + Math.random() * 2, Color.CYAN, 0, 2);

	}

	void makeShapeTwo(int x, int y, int counter) {
		int protSnoeksies;
		if (smoeksies < 0)protSnoeksies = 0;
		else protSnoeksies = smoeksies;
		
		if (counter == -1)
			return;
		smoke[counter] = new Smoke(x, y, (Math.random() * 5) + (Math.random() * protSnoeksies),
				(Math.random() * 5) + (Math.random() * protSnoeksies), (int) 20 + Math.random() * 8, Color.white, 1,
				5 + protSnoeksies);
	}
}
