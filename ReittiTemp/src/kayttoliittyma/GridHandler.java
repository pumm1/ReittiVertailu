package kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import reittitemp.Graph;
import reittitemp.Verkko;

public class GridHandler implements ActionListener {

    private JButton[][] squares;
    private int[][] grid;
    private Kayttoliittyma ui;
    private int green;
    private int red;
    private Graph graph;
    private Verkko verkko;

    public GridHandler(JButton[][] s, int[][] g, Kayttoliittyma k) { //tarvitaanko gridiä?
        squares = s;
        grid = g;
        ui = k;
        green = 0;
        red = 0;
    }

    /*
    prosessoidaan ruudun klikkaus - tyhjä muuttuu esteeksi, este aloitukseksi (jos sellaista ei ole), aloitus lopetukseksi ja lopetus tyhjäksi. Päivitetään sitten verkko
     */
    public void processGrid(int i, int j) {
        grid[i][j] = (grid[i][j] + 1) % 4;
        if (grid[i][j] == 0) {
            if (squares[i][j].getBackground() == Color.red) {
                red = 0;
            }
            squares[i][j].setBackground(Color.white);
        } else if (grid[i][j] == 1) {
            squares[i][j].setBackground(Color.black);
        } else if (grid[i][j] == 2) {
            if (green == 0) {
                squares[i][j].setBackground(Color.green);
                green = 1;
            } else {
                processGrid(i, j);
            }
        } else {
            if (squares[i][j].getBackground() == Color.green) {
                green = 0;
            }
            if (red == 0) {
                squares[i][j].setBackground(Color.red);
                red = 1;
            } else {
                processGrid(i, j);
            }
        }
        initGraph(); //päivitä verkko
    }

    public void resetGrid() {
        green = 0;
        red = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                squares[i][j].setBackground(Color.white);
            }
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public Verkko getVerkko() {
        return verkko;
    }

    public void initGraph() {
        System.out.println("updating graph..");
        verkko = new Verkko(grid);
        verkko.initGraph();
//        graph = new Graph(grid);
//        graph.initGraph();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (squares[i][j].getBackground() == Color.yellow) {
                    squares[i][j].setBackground(Color.white);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (source == squares[i][j]) {
                    processGrid(i, j);
                }
            }
        }
    }

}
