package reittitemp;

import java.util.HashMap;

//oma luokka BFS:n toteutukselle
public class Bfs implements Algorithm {

    private Graph graph;
    private Verkko verkko;
    private Queue<Vertex> queue;
    private HashMap<Vertex, Vertex> tree;
    private Vertex[][] nGrid;

    public Bfs(Graph g) {
        graph = g;
        queue = new Queue(2500);
        nGrid = graph.getNodeGrid();

    }

    public Bfs(Verkko v) {
        verkko = v;
        queue = new Queue(2500);
        nGrid = verkko.getNodeGrid();
    }

    @Override
    public HashMap<Vertex, Vertex> findRoute(Vertex s) {
        tree = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    nGrid[i][j].reset();
                    tree.put(nGrid[i][j], null);
                }

            }
        }
        s.start(); //color[s] = black, dist[s] = 0
        queue.enqueue(s);
        Vertex u = null;
        Vertex[] neighbours = null;
//        Array<Vertex> neigh = null;
//        List<Node> neighbours = null;
        while (!queue.isEmpty()) {

            u = queue.dequeue();
//            System.out.println("u:" + u.id());
//            neigh = verkko.getNeighbours(u.id());
            neighbours = u.getNeighbours();
//            for (int i = 0; i < neigh.getSize(); i++) {
//                Node v = neigh.get(i);
//                if (v != null) {
//                    System.out.println("v:" + v.id());
//                    if (v.getColor() == 0) {
//                        v.visit();
//                        v.incDist(u.getDist());
////                    System.out.println(neigh.get(i).getId() + " prev is : " + u.getId());
//                        v.setPrev(u);
//                        System.out.println(v.id() + " prev: " + u.id());
////                    System.out.println("v: " + v.getId() + ",  u: " + u.getId());
//                        queue.enqueue(v);
//                    }
//                }
//            }
//            System.out.println("");
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
        return null;
    }

}
