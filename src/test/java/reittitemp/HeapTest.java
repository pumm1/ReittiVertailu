package reittitemp;

import main.java.reittitemp.Heap;
import main.java.reittitemp.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeapTest {

    private Heap heap;

    @Before
    public void setUp() {

        heap = new Heap(10);
    }

    @Test
    public void konstrukotriToimii() {
        int size = heap.getSize();
        assertEquals(10, size);
        heap = new Heap(100);
        size = heap.getSize();
        assertEquals(100, size);
        heap = new Heap(-1);
        size = heap.getSize();
        assertEquals(2500, size);
        int count = heap.getCount();
        assertEquals(0, count);
    }

    @Test
    public void lisaysToimii() {
        Vertex t = new Vertex(1, 1);
        t.setDist(0);
        heap.insertNode(t);
        Vertex v = heap.getNodeFrom(0);
        int count = heap.getCount();
        assertEquals(1, count);
        assertEquals(t, v);

        Vertex s = new Vertex(1, 2);
        Vertex r = new Vertex(1, 3);

        s.setDist(2);
        r.setDist(4);

        heap.insertNode(s);
        heap.insertNode(r);
        count = heap.getCount();
        assertEquals(3, count);
        v = heap.getNodeFrom(2);
        assertEquals(r, v); //lisäysjärjestyksellä iso merkitys tässä vaiheessa!

        Vertex p = new Vertex(4, 4);
        p.setDist(1);
        heap.insertNode(p);
        v = heap.getNodeFrom(1);
        assertEquals(p, v);
        v = heap.getNodeFrom(2);
        assertEquals(r, v);
        v = heap.getNodeFrom(3);
        assertEquals(s, v);
        count = heap.getCount();
        assertEquals(4, count);
    }

    @Test
    public void heapifyToimii() {
        Vertex a0 = new Vertex(1, 1);
        a0.setDist(0);
        Vertex a1 = new Vertex(1, 2);
        a1.setDist(1);
        Vertex a2 = new Vertex(2, 2);
        a2.setDist(2);
        Vertex a3 = new Vertex(2, 3);
        a3.setDist(3);
        Vertex a4 = new Vertex(3, 3);
        a4.setDist(4);
        Vertex a5 = new Vertex(3, 4);
        a5.setDist(5);
        Vertex a6 = new Vertex(4, 4);
        a6.setDist(6);
        heap.insertNode(a0);
        heap.insertNode(a1);
        heap.insertNode(a2);
        heap.insertNode(a3);
        heap.insertNode(a4);
        heap.insertNode(a5);
        heap.insertNode(a6);

        heap.delMin();
        Vertex v = heap.getNodeFrom(0);
        assertEquals(a1, v);
        v = heap.getNodeFrom(3);
        assertEquals(a6, v);
        v = heap.getNodeFrom(5);
        assertEquals(a5, v);
        v = heap.getNodeFrom(1);
        assertEquals(a3, v);
        v = heap.getNodeFrom(2);
        assertEquals(a2, v);
        v = heap.getNodeFrom(4);
        assertEquals(a4, v);
    }

    @Test
    public void delMinToimii() {
        Vertex t = new Vertex(1, 1);
        Vertex s = new Vertex(1, 2);
        Vertex r = new Vertex(1, 3);
        t.setDist(0);
        s.setDist(2);
        r.setDist(4);

        heap.insertNode(r);
        heap.insertNode(s);
        heap.insertNode(t);

        Vertex v = heap.delMin();
        assertEquals(t, v);
        v = heap.delMin();
        assertEquals(s, v);
        v = heap.delMin();
        assertEquals(r, v);
        v = heap.delMin();
        assertEquals(null, v);
        t = new Vertex(2, 2);
        t.setDist(4);
        heap.insertNode(t);
        v = heap.delMin();
        assertEquals(t, v);
        v = heap.delMin();
        assertEquals(null, v);
    }
}