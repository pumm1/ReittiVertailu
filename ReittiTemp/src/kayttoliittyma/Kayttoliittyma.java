package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import reittitemp.Bfs;
import reittitemp.Dfs;
import reittitemp.Dijkstra;
import reittitemp.Graph;
import reittitemp.Vertex;
import reittitemp.Verkko;

public class Kayttoliittyma extends JFrame implements KeyListener {

    private JButton[][] squares;
    private Container contents;
    private GridHandler gridHandler;
    private int[][] grid;
    private HashMap<Vertex, Vertex> tree;

    public Kayttoliittyma(int[][] g) {
        super("ReittiVertailu");
        grid = g;
        JPanel panel = new JPanel(new GridLayout(50, 50));
        squares = new JButton[50][50];
        contents = getContentPane();
//        contents.setLayout(new GridLayout(50, 50));
        gridHandler = new GridHandler(squares, grid, this);

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                squares[i][j] = new JButton();
                if (grid[i][j] == 0) {
                    squares[i][j].setBackground(Color.white);
                } else {
                    squares[i][j].setBackground(Color.black);
                }
//                contents.add(squares[i][j]);
                squares[i][j].addActionListener(gridHandler);
                squares[i][j].addKeyListener(this);
                panel.add(squares[i][j]);
            }
        }
        gridHandler.initGraph();
//        Graph gr = gridHandler.getGraph();
        Verkko v = gridHandler.getVerkko();

        this.add(panel);
        JButton button = new JButton("FIND ROUTE");
        ButtonHandler bHandler = new ButtonHandler(v, this);
//        bHandler.setAlgorithm(new Bfs(v));
        bHandler.setAlgorithm(new Dfs(v));
//        bHandler.setAlgorithm(new Dijkstra(v));
        button.addActionListener(bHandler);
        contents.add(button, BorderLayout.SOUTH);

        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void procesGrid() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (grid[i][j] == 0) {
                    squares[i][j].setBackground(Color.white);
                } else {
                    squares[i][j].setBackground(Color.black);
                }
            }
        }
    }

    public void drawRoute(HashMap<Vertex, Vertex> h, Vertex s, Vertex u) {
//        squares[s.getX()][s.getY()].setBackground(Color.red);
        tree = h;
//        u = u.getPrev();
//        squares[u.getX()][u.getY()].setBackground(Color.green);
        if (u != null) {
            squares[u.getX()][u.getY()].setBackground(Color.yellow);
        }
//        u = tree.get(u);

        while (u != s && u != null) {
            squares[u.getX()][u.getY()].setBackground(Color.yellow);
//            u = tree.get(u);
            u = u.getPrev();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
