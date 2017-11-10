package rettitemp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Graph;
import reittitemp.Node;


public class GraphTest {

    private Graph g;
    private int[][] grid;
    private Node[][] nGrid;
    private Node n;
    

    @Before
    public void setUp() {
        grid = new int[50][50];
        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 1;
        g = new Graph(grid);
        g.initGraph();
        nGrid = g.getNodeGrid();
        
    }

    @Test
    public void nodeVerkkoToimii() {
        n = nGrid[0][0];
        assertEquals(null, n);
        n = nGrid[0][1];
        assertEquals(null, n);
        n = nGrid[0][2];
        assertEquals(null, n);
        int maara = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    maara++;
                }
            }
        }
        assertEquals(2497, maara);
    }

}
