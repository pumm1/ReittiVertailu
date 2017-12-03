
package ui;
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
//import reittitemp.Graph;
import reittitemp.Vertex;
import reittitemp.Verkko;

public class Kayttoliittyma extends JFrame implements KeyListener {

    private JButton[][] squares;
    private Container contents;
    private GridHandler gridHandler;
    private int[][] grid;
    private HashMap<Vertex, Vertex> tree;
    private int alg;
    private ButtonHandler bHandler;
    private Verkko verkko;

    public Kayttoliittyma(int[][] g) {
        super("ReittiVertailu");
        grid = g;
        alg = 0;
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
        verkko = gridHandler.getVerkko();

        this.add(panel);
        JButton button = new JButton("FIND ROUTE");
        bHandler = new ButtonHandler(verkko, this);
        setAlgorithm();
        button.addActionListener(bHandler);
        contents.add(button, BorderLayout.SOUTH);

        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void processGrid() {

        gridHandler.resetGrid();
    }

    public void drawRoute(Vertex s, Vertex u) {

        if (u != null) {
            squares[u.getX()][u.getY()].setBackground(Color.yellow);
        }

        while (u != s && u != null) {
            squares[u.getX()][u.getY()].setBackground(Color.yellow);
//            u = tree.get(u);
            u = u.getPrev();
        }
    }

    public void setAlgorithm() {
        String algo = "";
        if (alg == 0) {
            bHandler.setAlgorithm(new Bfs(verkko));
            algo = "bfs";
        } else if (alg == 1) {
            bHandler.setAlgorithm(new Dfs(verkko));
            algo = "dfs";
        } else {
            bHandler.setAlgorithm(new Dijkstra(verkko));
            algo = "dijkstra";
        }
        System.out.println("käytössä oleva algoritmi: " + algo);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent k) {
        if (k.getKeyCode() == KeyEvent.VK_A) {
            alg = (alg + 1) % 3;
            setAlgorithm();
        } else if (k.getKeyCode() == KeyEvent.VK_R) {
            verkko.resetGrid();
            processGrid();
            System.out.println("reset!");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}