package rettitemp;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Graph;
import reittitemp.Vertex;

public class GraphTest {

    private Graph g;
    private int[][] grid;
    private Vertex[][] nGrid;
    private Vertex n;

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

    @Test
    public void BFStoimii() {

        Vertex s = nGrid[1][0];
        HashMap<Vertex, Vertex> tree = g.BFS(s);
        Vertex u = nGrid[0][3];
        u = tree.get(u);
        assertEquals(nGrid[1][3], u);
        u = tree.get(u);
        assertEquals(nGrid[1][2], u);
        u = tree.get(u);
        assertEquals(nGrid[1][1], u);
        u = tree.get(u);
        assertEquals(s, u);
    }

}
