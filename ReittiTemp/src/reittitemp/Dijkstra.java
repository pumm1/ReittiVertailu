package reittitemp;

import java.util.*;

public class Dijkstra implements Algorithm {

    private Graph graph;
    private Heap heap;

    public Dijkstra(Graph g) {
        graph = g;
        heap = new Heap();
    }

    public void initHeap() {
        Node[][] nodes = graph.getNodeGrid();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nodes[i][j] != null) {
                    heap.insertNode(nodes[i][j]);
                }
            }
        }
    }

    @Override
    public HashMap<Node, Node> findRoute(Node s) {
        initHeap();
        s.start();
        int nCount = heap.getCount();
        Node[] nodes = heap.getNodes();
        while (nCount > 0) {
          
            Node u = heap.delMin();

//            System.out.println("u.getDist: " + u.getDist());
            Node[] adj = u.getNeighbours();

            for (Node v : adj) {
                u.relax(v);
                int i = 0;
                while (i != nCount) {//decKey
                    if (nodes[i] == u) {
                        break;
                    }
                    i++;
                }
                heap.heapify(heap.parent(i));
            }
            nCount = heap.getCount();
        }
        return null;
    }

}
