package main.java.reittitemp;

public class Dfs implements Algorithm { //edes jotain, jonka toteuttaminen ei tuottanut ongelmia

    /**
     *@param verkko 
     *@param nGrid verkon nodejen matriisiesitys
     */
    private Verkko verkko;
    private Vertex[][] nGrid;
    
    /**
    *@param v verkon parametri
    */
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
    
    /**
     *@param u node, mitä tutkitaan
     */
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

    /**
    *@param s aloitusnode haulle
    */
    @Override
    public void findRoute(Vertex s) {
        DFS(s);
        
    }

}
