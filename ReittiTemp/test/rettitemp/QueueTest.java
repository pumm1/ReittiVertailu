package rettitemp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Vertex;
import reittitemp.Queue;

public class QueueTest {

    private Queue<Vertex> q;
    private Vertex n1;
    private Vertex n2;
    private Vertex n3;

    @Before
    public void setUp() {
        q = new Queue(3);
        n1 = new Vertex(10, 10);
        n2 = new Vertex(10, 11);
        n3 = new Vertex(10, 9);
    }

    @Test
    public void jonoToimii() {
        q.enqueue(n1);
        q.enqueue(n2);
        q.enqueue(n3);
        Vertex i = q.dequeue();
        assertEquals(n1, i);
        i = q.dequeue();
        assertEquals(n2, i);
        i = q.dequeue();
        assertEquals(n3, i);
        i = q.dequeue();
        assertEquals(null, i);
    }

}
