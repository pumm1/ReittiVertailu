package reittitemp;

import java.util.HashMap;
import reittitemp.Queue;

public class Graph {

    private int[][] grid; //mallinnettan verkolle ruudukon sisältö
    private Node[][] nGrid; //mallinnetaan myös nodeverkko
    private HashMap<Node, Node> tree; //tree-rakennelma alustavasti Javan hashmapilla, myöhemmin oma toteutus
    private Queue<Node> queue;

    public Graph(int[][] g) {
        grid = g;
        nGrid = new Node[50][50]; //aletetaan alkuun ainakin ruudukko kokoon 50x50
        tree = new HashMap<>();
        queue = new Queue(2500);
    }

    public Node[][] getNodeGrid() {
        return nGrid;
    }

    //alustetaan verkko ja nodet
    public void initGraph() {
        //alustetaan nodet verkon tietojen perusteella
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (grid[i][j] != 1) { //merkatan gridiin 1 = este, 0 =tyhjä
                    Node n = new Node(i, j);
                    nGrid[i][j] = n;
                }
            }
        }

        //yhdistetään nodet verkossa toisiinsa
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    if (i + 1 < 50) {
                        if (nGrid[i + 1][j] != null) {
                            nGrid[i][j].connect(nGrid[i + 1][j]);
                        }
                    }
                    if (i - 1 >= 0) {
                        if (nGrid[i - 1][j] != null) {
                            nGrid[i][j].connect(nGrid[i - 1][j]);
                        }
                    }
                    if (j + 1 < 50) {
                        if (nGrid[i][j + 1] != null) {
                            nGrid[i][j].connect(nGrid[i][j + 1]);
                        }
                    }
                    if (j - 1 >= 0) {
                        if (nGrid[i][j - 1] != null) {
                            nGrid[i][j].connect(nGrid[i][j - 1]);
                        }
                    }
                }
            }
        }
    }
}
