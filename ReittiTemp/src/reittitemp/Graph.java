package reittitemp;

import java.util.HashMap;
import reittitemp.Queue;

public class Graph {

    private int[][] grid; //mallinnettan verkolle ruudukon sisältö
    private Vertex[][] nGrid; //mallinnetaan myös nodeverkko
//    private HashMap<Vertex, Vertex> tree; //tree-rakennelma alustavasti Javan hashmapilla, myöhemmin oma toteutus
    private Queue<Vertex> queue;
    private Vertex u;
    private Vertex s;

    public Graph(int[][] g) {
        grid = g;
        nGrid = new Vertex[50][50]; //aletetaan alkuun ainakin ruudukko kokoon 50x50
        queue = new Queue<>(2500);
    }

    public Vertex getS() {
        return s;
    }

    public Vertex getU() {
        return u;
    }

    public Vertex[][] getNodeGrid() {
        return nGrid;
    }

    public void updateU(Vertex i) {
        u = i;
    }

    public void updateS(Vertex i) {
        s = i;
    }

    //alustetaan verkko ja nodet
    public void initGraph() {
        //alustetaan nodet verkon tietojen perusteella
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (grid[i][j] != 1) { //merkatan gridiin 1 = este, 0 =tyhjä, 2 = aloitus, 3 = stop
                    Vertex n = new Vertex(i, j);
                    nGrid[i][j] = n;
                    if (grid[i][j] == 2) {
                        updateU(nGrid[i][j]);
                        System.out.println("u updated");
                    } else if (grid[i][j] == 3) {
                        updateS(nGrid[i][j]);
                        System.out.println("s updated");
                    }
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
                        if (j + 1 < 50) {
                            if (nGrid[i + 1][j + 1] != null) {
                                nGrid[i][j].connect(nGrid[i + 1][j + 1]);
                            }
                        }
                        if (j - 1 >= 0) {
                            if (nGrid[i + 1][j - 1] != null) {
                                nGrid[i][j].connect(nGrid[i + 1][j - 1]);
                            }
                        }
                    }
                    if (i - 1 >= 0) {
                        if (nGrid[i - 1][j] != null) {
                            nGrid[i][j].connect(nGrid[i - 1][j]);
                        }
                        if (j + 1 < 50) {
                            if (nGrid[i - 1][j + 1] != null) {
                                nGrid[i][j].connect(nGrid[i - 1][j + 1]);
                            }
                        }
                        if (j - 1 >= 0) {
                            if (nGrid[i - 1][j - 1] != null) {
                                nGrid[i][j].connect(nGrid[i - 1][j - 1]);
                            }
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

    //leveyssuuntainen läpikäynti
    //treen toteutus pitää korvata omalla systeemillä vielä
//    public HashMap<Vertex, Vertex> BFS(Vertex s) {
////        tree = new HashMap<>();
//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 50; j++) {
//                if (nGrid[i][j] != null) {
//                    nGrid[i][j].reset();
////                    tree.put(nGrid[i][j], null);
//                }
//
//            }
//        }
//        s.start(); //color[s] = black, dist[s] = 0
//        queue.enqueue(s);
//        Vertex u = null;
//        Vertex[] neighbours = null;
////        List<Node> neighbours = null;
//        while (!queue.isEmpty()) {
//            u = queue.dequeue();
//            neighbours = u.getNeighbours();
////            System.out.println("");
//            for (Vertex v : neighbours) {
//                if (v != null) {
//                    if (v.getColor() == 0) {
//                        v.visit(); //color =  black
//                        v.incDist(s.getDist()); //dist[v] = dist[u] + 1
////                        tree.put(v, u);
//                        queue.enqueue(v);
//                    }
//                }
//            }
//        }
//        return tree;
//    }

    //ilmeisesti java näkeekin koordinaatiston (Y,X) eikä (X,Y)
    public void printGraph() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("o");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }
}
