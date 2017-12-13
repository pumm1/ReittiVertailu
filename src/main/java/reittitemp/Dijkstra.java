package main.java.reittitemp;

public class Dijkstra implements Algorithm {

    /**
     * @param heap pino, jota algoritmi käyttää hyödykseen
     * @param verkko
     * @param nodes nodelista
     */
    private Heap heap;
    private Verkko verkko;
    private Array<Vertex> nodes;

    /**
     * @param v verkkon parametri
     */
    public Dijkstra(Verkko v) {
        verkko = v;
        heap = new Heap();
    }

    /**
     * alustas pino algoritmia varten
     */
    public void initHeap() {
        Vertex[][] nodes = verkko.getNodeGrid();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nodes[i][j] != null) {
                    heap.insertNode(nodes[i][j]);
                }
            }
        }
    }

    /**
     *alustetaan nodet 
     *@param s alusta node s
     */
    public void init(Vertex s) {
        for (int i = 0; i < nodes.getSize(); i++) {
            Vertex v = nodes.get(i);
            v.setPrev(null);
        }
        s.setDist(0);
        s.start();
    }

    
    /**
     *@param s aloitusnode algoritmille
     */
    @Override
    public void findRoute(Vertex s) {
        nodes = verkko.getVertexes();
        init(s);
        initHeap();
        Vertex u = null;
        while (!heap.isEmpty()) {
            u = heap.delMin();
            Vertex[] adj = u.getNeighbours();
            for (Vertex v : adj) {
                if (v != null) {
                    u.relax(v);
                    heap.decKey(v);
                }

            }
        }
    }

}
