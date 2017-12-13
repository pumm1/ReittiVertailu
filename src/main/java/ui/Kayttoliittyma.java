package main.java.ui;

import main.java.reittitemp.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class Kayttoliittyma extends JFrame implements KeyListener {

    /**
     *Käyttöliittymä hoitaa ohjelman visuaalisen puolen
     * @param squares verkon solmut nappeina
     * @param contents käyttöliittymän kontentit
     * @param gridHandler hoitaa ruudukon logiikan
     * @param grid verkon matriisiesitys, koska kyseessä on visuaalisesti ruudukko
     * @param alg kuvastaa käytettyä algoritmia numeraalisesti
     * @param bHandler hoitaa find route-napin logiikan
     * @param verkko on itse verkko, missä reittihaku tehdään
     * @param konsoli on käyttöliittymän teksti-ikkuna
     * @param txt konsolin teksti
     *
     */
    private JButton[][] squares;
    private Container contents;
    private GridHandler gridHandler;
    private int[][] grid;
    private int alg;
    private ButtonHandler bHandler;
    private Verkko verkko;
    private JTextArea konsoli;
    private String txt;

    /**
     *@param g gridin parametri
     */
    public Kayttoliittyma(int[][] g) {
        super("ReittiVertailu");
        konsoli = new JTextArea();
        konsoli.setSize(800, 50);
        konsoli.setEditable(false);
        txt = "";
        konsoliWrite(txt);
        grid = g;
        alg = 0;
        JPanel panel = new JPanel(new GridLayout(50, 50));
        squares = new JButton[50][50];
        contents = getContentPane();
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
        contents.add(button, BorderLayout.NORTH);
        contents.add(konsoli, BorderLayout.SOUTH);
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void processGrid() {

        gridHandler.resetGrid();
    }
    
    /**
     *@param t konsolin teksti
     */
    public void konsoliWrite(String t){
        txt = t;
        konsoli.setText(txt);
    }

    /**
     *@param s start
     *@param u loppunode
     *@param aika käytetty aika
     */
    public void drawRoute(Vertex s, Vertex u, long aika) {
        String algo = returnAlgorithm();
        konsoliWrite(algo + " - aikaa meni: "  + aika + " ms (reittiä ei ole, jos keltaista ei näy)");
        if (u != null) {
            squares[u.getX()][u.getY()].setBackground(Color.yellow);
        }

        while (u != s && u != null) {
            squares[u.getX()][u.getY()].setBackground(Color.yellow);
//            u = tree.get(u);
            u = u.getPrev();
        }
    }
    
    private String returnAlgorithm(){
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
        return algo;
    }

    public void setAlgorithm() {
        String algo = returnAlgorithm();
        konsoliWrite("käytössä oleva algoritmi: " + algo);
       
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    /**
     *@param k keyEventin parametri
     */
    @Override
    public void keyPressed(KeyEvent k) {
        if (k.getKeyCode() == KeyEvent.VK_A) {
            alg = (alg + 1) % 3;
            setAlgorithm();
        } else if (k.getKeyCode() == KeyEvent.VK_R) {
            verkko.resetGrid();
            processGrid();
            konsoliWrite("reset!");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
