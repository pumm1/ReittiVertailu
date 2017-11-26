package rettitemp;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Bfs;
import reittitemp.Graph;
import reittitemp.Vertex;

public class BfsTest {

    private Graph graph;
    private Bfs bfs;

    @Before
    public void setUp() {
        int grid[][] = new int[50][50];
        grid[1][0] = 1;
        grid[1][1] = 1;
        int i = 0;

        graph = new Graph(grid);
        graph.initGraph();
        bfs = new Bfs(graph);
    }

    @Test
    public void BFSToimiii() {
        
        Vertex[][] nGrid = graph.getNodeGrid();
        Vertex s = nGrid[0][0];
        HashMap<Vertex, Vertex> tree = bfs.findRoute(s);
        Vertex u = tree.get(nGrid[2][2]);
        assertEquals(nGrid[1][2], u);
        u = tree.get(u);
        assertEquals(nGrid[0][2], u);
        u = tree.get(u);
        assertEquals(nGrid[0][1], u);
        u = tree.get(u);
        assertEquals(s, u);
    }

}
