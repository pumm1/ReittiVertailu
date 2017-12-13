package reittitemp;

import main.java.reittitemp.Dijkstra;
import main.java.reittitemp.Verkko;
import main.java.reittitemp.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
    private Verkko graph;
    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        int grid[][] = new int[50][50];
        grid[1][0] = 1;
        grid[1][1] = 1;
        int i = 0;
        for (i = 0; i< 49; i++){
            grid[8][i] = 1;
        }
        graph = new Verkko(grid);
        graph.initGraph();
        dijkstra = new Dijkstra(graph);
    }
    
    @Test
    public void reittiLöytyyYhdenEsteenLuota(){
        Vertex[][] nGrid = graph.getNodeGrid();
        Vertex s = nGrid[0][0];
        dijkstra.findRoute(s);
        Vertex u = nGrid[2][2];
        while(true){
            if(u == null){
                break;
            }else if(u == s){
                break;
            }
            u = u.getPrev();
        }
        assertEquals(s, u);
    }

    @Test
    public void ReittiLöytyyAinoanAukonKautta(){
        Vertex[][] nGrid = graph.getNodeGrid();
        Vertex s = nGrid[0][0];
        dijkstra.findRoute(s);
        Vertex u = nGrid[9][0];
        while(true){
            if(u == null){
                break;
            }else if(u == s){
                break;
            }
            u = u.getPrev();
        }
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
        dijkstra.findRoute(s);
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

}
