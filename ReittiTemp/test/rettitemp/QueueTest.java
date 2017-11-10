package rettitemp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reittitemp.Node;
import reittitemp.Queue;

public class QueueTest {

    private Queue<Node> q;
    private Node n1;
    private Node n2;
    private Node n3;

    @Before
    public void setUp() {
        q = new Queue(3);
        n1 = new Node(10, 10);
        n2 = new Node(10, 11);
        n3 = new Node(10, 9);
    }

    @Test
    public void jonoToimii() {
        q.enqueue(n1);
        q.enqueue(n2);
        q.enqueue(n3);
        Node i = q.dequeue();
        assertEquals(n1, i);
        i = q.dequeue();
        assertEquals(n2, i);
        i = q.dequeue();
        assertEquals(n3, i);
        i = q.dequeue();
        assertEquals(null, i);
    }

}
