package Java2D.Hoofdstuk4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Exe4_13 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exercise 4.13");
        JPanel panel = new Excersise13();

        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Exe4_13() {

    }

}

class Excersise13 extends JPanel implements ActionListener {

    int n = 181;
    boolean[][] cells1;
    boolean[][] cells2;

    public Excersise13() {

        setPreferredSize(new Dimension(181 * 3, 181 * 3));
        setBackground(Color.WHITE);
        cells1 = new boolean[n][n];
        cells2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells1[i][j] = false;
                cells2[i][j] = false;
            }
        }
        cells1[(n/2)][(n/2)] = true;
        Timer timer = new Timer(500, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.LIGHT_GRAY);
        int p = 0;
        int c = 3;
        int len = 453;
        for (int i = 0; i <= n; i++) {
            g2.drawLine(0, p, len, p);
            g2.drawLine(p, 0, p, len);
            p += 3;
        }
        g2.setColor(Color.black);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells1[i][j]) {
                    int x = i * c;
                    int y = j * c;
                    g2.fillOval(x, y, c, c);
                }
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        boolean white = false;
        boolean black = true;
        boolean[][] cells = cells1;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                cells2[i][j] = cells[i][j];
                int nb = neighbors(i, j);
                if (cells[i][j]== white && nb != 1) {
                    cells2[i][j] = black;
                } else if (cells[i][j]== black && (nb==1||nb==3 )) {
                    cells2[i][j] = black;
                } else {
                    cells2[i][j] = white;
                }
            }
        }

        cells1 = cells2;
        cells2 = cells;
        repaint();
    }

    private int neighbors(int x, int y) {
        return countNeighbor(x, y-1) + countNeighbor(x, y+1) + countNeighbor(x-1, y) + countNeighbor(x+1, y);
    }

    private int countNeighbor(int x, int y) {
        if (x<0||x>n-1) { return 0; }
        if (y<0||y>n-1) { return 0; }
        return cells1[x][y] ? 1 : 0;
    }

}