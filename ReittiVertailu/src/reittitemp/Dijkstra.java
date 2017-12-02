
package reittitemp;
import java.util.*;

public class Dijkstra implements Algorithm {

    /*
    TÄMÄ EI TOIMI VIELÄ YHTÄÄN LUOTETTAVASTI - EN OLE SAANUT KORJATTUA ONGLEMIA
    -Algoritmi löytää reitin nyt, kun vihreä ruutu on punaisesta katsottuna vasemmalla ylhäällä/lähes suoraan ylhäällä, 
    välillä liian suuri etäisyys voi myös vaikuttaa, kuten myös suurempi määrä esteitä
     */
//    private Graph graph;
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
    }

    @Override
    public void findRoute(Vertex s) {
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
//            System.out.println("u.getDist: " + u.getDist());
            Vertex[] adj = u.getNeighbours();
            System.out.println("----");
            System.out.println("u: " + u.id());
            for (Vertex v : adj) {
//                int dist = v.getDist();
                if (v != null) {
                    System.out.println("v: " + v.id());
                    u.relax(v);
                    heap.dec(v);
                }else{
                    break;
                }
//                int i = 0;
//                    if (nodes[i] == u) {
//                        break;
//                    }
//                    i++;
//                }
//                heap.heapify(heap.parent(i));

            }
//            nCount = heap.getCount();
//            System.out.println("heapSize:" + nCount);
        }
        System.out.println("done");
    }

}
