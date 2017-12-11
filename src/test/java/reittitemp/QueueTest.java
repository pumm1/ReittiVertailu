
package reittitemp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Vertex;
import reittitemp.Queue;

public class QueueTest {

    private Queue<Vertex> jono;
    private Vertex n1;
    private Vertex n2;
    private Vertex n3;

    @Before
    public void setUp() {
        jono = new Queue(3);
        n1 = new Vertex(10, 10);
        n2 = new Vertex(10, 11);
        n3 = new Vertex(10, 9);
    }

    @Test
    public void jonoToimii() {
        jono.enqueue(n1);
        jono.enqueue(n2);
        jono.enqueue(n3);
        Vertex i = jono.dequeue();
        assertEquals(n1, i);
        i = jono.dequeue();
        assertEquals(n2, i);
        i = jono.dequeue();
        assertEquals(n3, i);
        
        jono.enqueue(n1);
        i = jono.dequeue();
        assertEquals(n1, i);
        i = jono.dequeue();
        assertEquals(null, i);
    }

}