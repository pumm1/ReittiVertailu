package reittitemp;

import main.java.reittitemp.Bfs;
import main.java.reittitemp.Verkko;
import main.java.reittitemp.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BfsTest {

    private Verkko graph;
    private Bfs bfs;

    @Before
    public void setUp() {
        int grid[][] = new int[50][50];
        grid[1][0] = 1;
        grid[1][1] = 1;
        int i = 0;

        graph = new Verkko(grid);
        graph.initGraph();
        bfs = new Bfs(graph);
    }

    @Test
    public void reittiLoytyyYhdenEsteenLuota() {

        Vertex[][] nGrid = graph.getNodeGrid();
        Vertex s = nGrid[0][0];
        bfs.findRoute(s);
        Vertex u = nGrid[2][2];
        u = u.getPrev();
        u = u.getPrev();
        u = u.getPrev();
        u = u.getPrev();
        assertEquals(s, u);
    }
    
    @Test
    public void reittiaEiLoydy(){
        int grid[][] = new int[50][50];
        for (int i = 0; i < 50; i++) {
            grid[1][i] = 1;
        }
        graph = new Verkko(grid);
        graph.initGraph();
        Vertex[][] nGrid = graph.getNodeGrid();
        Vertex s = nGrid[0][0];
        bfs.findRoute(s);
        nGrid = graph.getNodeGrid();
        Vertex u = nGrid[2][0];
        
        while(true){
            if(u == s){
                break;
            }else if(u == null){
                break;
            }
            u = u.getPrev();
        }
        assertEquals(null,u);
    }

    @Test
    public void reittiLoytyyAinoanAukonLapi() {
        int grid[][] = new int[50][50];
        for (int i = 0; i < 49; i++) {
            grid[1][i] = 1;
        }
        graph = new Verkko(grid);
        graph.initGraph();
        Vertex[][] nGrid = graph.getNodeGrid();
        Vertex s = nGrid[0][0];
        bfs.findRoute(s);
        nGrid = graph.getNodeGrid();
        Vertex u = nGrid[2][0];
        
        while(true){
            if(u == s){
                break;
            }else if(u == null){
                break;
            }
            u = u.getPrev();
        }
        assertEquals(s,u);
    }

}
