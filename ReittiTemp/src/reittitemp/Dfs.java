package reittitemp;

import java.util.HashMap;

public class Dfs implements Algorithm {

    private Verkko verkko;
    private Vertex[][] nGrid;

    public Dfs(Verkko v) {
        verkko = v;
        nGrid = verkko.getNodeGrid();
    }

    public void DFS(Vertex s) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    nGrid[i][j].reset();
                }
            }
        }
        DFSvisit(s);
    }

    public void DFSvisit(Vertex u) {
        u.visit();
        Vertex[] neighbours = u.getNeighbours();
        for (Vertex i : neighbours) {
            if (i != null) {
                if (i.getColor() == 0) {
                    i.setPrev(u);
                    DFSvisit(i);
                }
            }
        }

    }

    @Override
    public HashMap<Vertex, Vertex> findRoute(Vertex s) {
        DFS(s);
        return null;
    }

}
