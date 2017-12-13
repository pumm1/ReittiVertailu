package reittitemp;

import main.java.reittitemp.Dfs;
import main.java.reittitemp.Verkko;
import main.java.reittitemp.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DfsTest {

    private Verkko graph;
    private Dfs dfs;

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
        dfs = new Dfs(graph);
    }

    @Test
    public void reittiLöytyyHelposti(){
        Vertex[][] grid = graph.getNodeGrid();
        Vertex s = grid[0][0];
        Vertex u = grid[2][2];
        
        dfs.findRoute(s);
        while(true){
            if (u == null){
                break;
            }else if (u == s){
                break;
            }
            u = u.getPrev();
        }
        assertEquals(s, u);
    }
    
    @Test
    public void ainoaReittiLöytyy(){
     Vertex[][] grid = graph.getNodeGrid();
        Vertex s = grid[0][0];
        Vertex u = grid[9][0];
        
        dfs.findRoute(s);
        while(true){
            if (u == null){
                break;
            }else if (u == s){
                break;
            }
            u = u.getPrev();
        }
        assertEquals(s, u);   
    }
    
    @Test
    public void reittiaEiLöydy(){
        int grid[][] = new int[50][50];
        grid[1][0] = 1;
        grid[1][1] = 1;
        int i = 0;
        for (i = 0; i< 50; i++){
            grid[8][i] = 1;
        }
        graph = new Verkko(grid);
        graph.initGraph();
        dfs = new Dfs(graph);
        
        Vertex[][] g = graph.getNodeGrid();
        Vertex s = g[0][0];
        Vertex u = g[9][0];
        
        dfs.findRoute(s);
        while(true){
            if (u == null){
                break;
            }else if (u == s){
                break;
            }
            u = u.getPrev();
        }
        assertEquals(null, u);   
    }
}
