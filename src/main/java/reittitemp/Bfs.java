package main.java.reittitemp;

public class Bfs implements Algorithm {

    /**
     *@param verkko nimi kertonee kaiken
     *@param queue nodejono
     *@param nGrid matriisiesitys nodeille
     */
    private Verkko verkko;
    private Queue<Vertex> queue;
    private Vertex[][] nGrid;

    /**
     *@param v verkon parametri
     */
    public Bfs(Verkko v) {
        verkko = v;
        queue = new Queue<Vertex>(2500);
        nGrid = verkko.getNodeGrid();
    }
    
    /**
     *@param s aloitusnode algoritmille 
     */
    @Override
    public void findRoute(Vertex s) {
//        tree = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    nGrid[i][j].reset();
//                    tree.put(nGrid[i][j], null);
                }

            }
        }
        s.start(); //color[s] = black, dist[s] = 0
        queue.enqueue(s);
        Vertex u = null;
        Vertex[] neighbours = null;
        while (!queue.isEmpty()) {
            u = queue.dequeue();
            neighbours = u.getNeighbours();
            for (Vertex v : neighbours) {
                if (v != null) {
                    if (v.getColor() == 0) {
                        v.visit(); //color =  black
                        v.incDist(s.getDist()); //dist[v] = dist[u] + 1
//                        tree.put(v, u);
                        v.setPrev(u);
                        queue.enqueue(v);
                    }
                }
            }
        }
    }

}