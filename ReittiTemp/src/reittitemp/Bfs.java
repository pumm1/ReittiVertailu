package reittitemp;

import java.util.HashMap;

//oma luokka BFS:n toteutukselle
public class Bfs implements Algorithm{

    private Graph graph;
    private Queue<Node> queue;
    private HashMap<Node, Node> tree;
    private Node[][] nGrid;

    public Bfs(Graph g) {
        graph = g;
        queue = new Queue(2500);
        nGrid = graph.getNodeGrid();

    }

    @Override
    public HashMap<Node, Node> findRoute(Node s) {
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
        Node u = null;
        Node[] neighbours = null;
//        List<Node> neighbours = null;
        while (!queue.isEmpty()) {
            u = queue.dequeue();
            neighbours = u.getNeighbours();
//            System.out.println("");
            for (Node v : neighbours) {
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
