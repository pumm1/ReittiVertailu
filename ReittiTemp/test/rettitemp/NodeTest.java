package rettitemp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Node;

public class NodeTest {

    private Node n1;
    private Node n2;

    @Before
    public void setUp() {
        n1 = new Node(10, 10);
        n2 = new Node(10, 11);

    }

    @Test
    public void konstruktoriToimii() {
        int x = n1.getX();
        int y = n1.getY();
        assertEquals(10, x);
        assertEquals(10, y);
        int color = n1.getColor();
        assertEquals(0, color);

        int dist = n1.getDist();
        assertEquals(99999, dist);

    }

}
