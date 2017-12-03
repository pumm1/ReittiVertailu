
package reittitemp;
import java.util.*;

public class Dijkstra implements Algorithm {

    /*
    SE TOIMIIIIIIIIIIIIII!!!!!!!!!!!!!!!!!!!! (tosin ei ihan 100% kuten oikea dijkstra
    -decKey ei ole sellainen kuin alkuperäisessä ja taitaa olla himpun verran vaativampi aikavaatimukseltaan
    -tämä johtuu vaan muun koodin rakenteesta
     */
    private Heap heap;
    private Verkko verkko;
    private Array<Vertex> nodes;
    private Array<Edge> edges;

//    public Dijkstra(Graph g) {
//        graph = g;
//        heap = new Heap();
//    }

    public Dijkstra(Verkko v) {
        verkko = v;
        heap = new Heap();
    }

    public void initHeap() {
////        Vertex[][] nodes = graph.getNodeGrid();
        Vertex[][] nodes = verkko.getNodeGrid();
        
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nodes[i][j] != null) {
//                    System.out.println("inserting " + nodes[i][j].id() + ", w:" + nodes[j][j].getDist());
                    heap.insertNode(nodes[i][j]);
                }
            }
        }
//        for (int i = 0; i < nodes.getSize(); i++) {
//            Vertex v = nodes.get(i);
//            heap.insertNode(v);
//        }
    }

    public void init(Vertex s) {
        System.out.println("nodes.getSize(): " + nodes.getSize());
        for (int i = 0; i < nodes.getSize(); i++) {
//            System.out.println("init i: " + i);
            Vertex v = nodes.get(i);
//            v.setDist(9999);
            v.setPrev(null);
        }
        s.setDist(0);
        s.start();
        System.out.println("s coordinates: " + s.getY() + ", " + s.getX());
    }

    @Override
    public void findRoute(Vertex s) {
        System.out.println("DIJKSTRA STARTING");
        nodes = verkko.getVertexes();
        System.out.println("alkaa");
        init(s);
        initHeap();
        int nCount = heap.getCount();
//        Vertex[] nodes = heap.getNodes();
        Vertex u = null;
        System.out.println("heapSize:" + nCount);
        while (!heap.isEmpty()) {
            u = heap.delMin();
            System.out.println("u (x,y) - dist: " + u.getY() + ", " + u.getX() + " - " + u.getDist());
            Vertex[] adj = u.getNeighbours();
            for (Vertex v : adj) {
                if (v != null) {
//                    System.out.println("v: " + v.id());
                    int t = u.relax(v);
                    heap.decKey(v);
                }

            }
        }
        System.out.println("done");
    }

}
