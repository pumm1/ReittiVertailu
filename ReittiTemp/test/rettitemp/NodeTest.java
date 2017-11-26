package rettitemp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Vertex;

public class NodeTest {

    private Vertex n1;
    private Vertex n2;
    private Vertex n3;
    private Vertex n4;
    private Vertex n5;
    private Vertex n6;

    @Before
    public void setUp() {
        n1 = new Vertex(10, 10);
        n2 = new Vertex(10, 11);
        n3 = new Vertex(10, 9);
        n4 = new Vertex(9, 10);
        n5 = new Vertex(11, 10);
        n6 = new Vertex(10, 11);

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

    @Test
    public void naapurienYhdistäminenToimii() {
        n1.connect(n2);
        Vertex[] t = n1.getNeighbours();
        int maara = 0;
        for (int i = 0; i < 4; i++) {
            if (t[i] != null) {
                maara++;
            }
        }
        assertEquals(1, maara);
        assertEquals(n2, t[0]);
        maara = 0;
        t = n2.getNeighbours();
        for (int i = 0; i < 4; i++) {
            if (t[i] != null) {
                maara++;
            }
        }
        assertEquals(1, maara);
        assertEquals(n1, t[0]);

        n1.connect(n3);
        n1.connect(n4);
        n1.connect(n5);
        n1.connect(n6);

        t = n1.getNeighbours();
        boolean toimii = false;
        maara = 0;
        for (int i = 0; i < 4; i++) {
            if (t[i] == n6) {
                break;
            }
            maara++;
        }
        if (maara == 4) {
            toimii = true;
        }
        assertEquals(true, toimii);
    }
    
    @Test
    public void visitToimii(){
        n1.visit();
        int color = n1.getColor();
        assertEquals(1, color);
    }

}
