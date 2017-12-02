package reittitemp;

import java.util.HashMap;

//oma luokka BFS:n toteutukselle
public class Bfs implements Algorithm {

    private Graph graph;
    private Verkko verkko;
    private Queue<Vertex> queue;
//    private HashMap<Vertex, Vertex> tree;//
    private Vertex[][] nGrid;

    public Bfs(Graph g) {
        graph = g;
        queue = new Queue<>(2500);
        nGrid = graph.getNodeGrid();

    }

    public Bfs(Verkko v) {
        verkko = v;
        queue = new Queue<Vertex>(2500);
        nGrid = verkko.getNodeGrid();
        System.out.println(".......");
    }
    
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
