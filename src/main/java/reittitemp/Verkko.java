package main.java.reittitemp;


public class Verkko {

    /**
     *@param list vieruslista
     *@param grid matriisiesitys verkon ruudukon arvoille
     *@param nGrid nodejen matriisiesitys
     *@param s aloitus
     *@param u node, josta haetaan reitti s:ään
     *@param vertexes nodet taulussa
     */
    private Array<Array<Vertex>> list;
    private int[][] grid;
    private Vertex[][] nGrid;
    private Vertex s;
    private Vertex u;
    private Array<Vertex> vertexes;

    /**
     *@param g gridin arvo
     */
    public Verkko(int[][] g) {
        nGrid = new Vertex[50][50];
        grid = g;
//        adjList = new HashMap<>();
        list = new Array<Array<Vertex>>(2500);
        for (int i = 0; i < 2500; i++) {
            Array<Vertex> a = new Array<>(4);
            list.add(a);
        }
        vertexes = new Array<>(2500); //ei ehkä tarvita

    }

    public void resetGrid() {
        s = null;
        u = null;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public Vertex[][] getNodeGrid() {
        return nGrid;
    }


    public Array<Vertex> getVertexes() {
        return vertexes;
    }

    public Array<Array<Vertex>> getNodes() {
        return list;
    }

    /**
     *alusta verkko
     */
    public void initGraph() {
        int id = 0;
        int count = 0;
        vertexes = new Array(2500);
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (grid[i][j] == 1) {
                    Array<Vertex> a = list.get(id);
                    a = null;
                    nGrid[i][j] = null;
                } else {
                    Array<Vertex> a = list.get(id);
                    a = new Array<>(4);
                    count++;
                    nGrid[i][j] = new Vertex(id, i, j);
                    vertexes.add(nGrid[i][j]);
                    if (grid[i][j] == 2) {
                        u = nGrid[i][j];
                    } else if (grid[i][j] == 3) {
                        s = nGrid[i][j];
                    }
                }
                id++;
            }
        }
        connectNodes();
    }

    /**
     *yhdistä nodet verkossa toisiinsa
     */
    public void connectNodes() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    if (i + 1 < 50) {
                        if (nGrid[i + 1][j] != null) {
                            addEdge(nGrid[i][j], nGrid[i + 1][j]);
                        }
                    }
                    if (i - 1 >= 0) {
                        if (nGrid[i - 1][j] != null) {
                            addEdge(nGrid[i][j], nGrid[i - 1][j]);
                        }
                    }
                    if (j + 1 < 50) {
                        if (nGrid[i][j + 1] != null) {
                            addEdge(nGrid[i][j], nGrid[i][j + 1]);
                        }
                    }
                    if (j - 1 >= 0) {
                        if (nGrid[i][j - 1] != null) {
                            addEdge(nGrid[i][j], nGrid[i][j - 1]);
                        }
                    }
                }
            }
        }
    }

    /**
     *@param v yhdistetään alempaan
     *@param w yhdistetään ylempään
     */
    public void addEdge(Vertex v, Vertex w) {
        list.get(v.id()).add(w);
        list.get(w.id()).add(v);
        v.connect(w);

    }

    /**
     *@param i indeksi
     */
    public Array<Vertex> getNeighbours(int i) {
        if (i < 2500) {
            return list.get(i);
        }
        return null;
    }

    public Vertex getS() {
        return s;
    }

    public Vertex getU() {
        return u;
    }

    /**
     *@param i node u:n uusi node
     */
    public void updateU(Vertex i) {
        u = i;
    }
    /**
     *@param i node s:n uusi ndoe
     */
    public void updateS(Vertex i) {
        s = i;
    }

}
