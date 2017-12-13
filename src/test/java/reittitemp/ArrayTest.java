package reittitemp;

import main.java.reittitemp.Array;
import main.java.reittitemp.Vertex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayTest {

    private Array<Integer> array;
    private Array<Vertex> arr;
    @Before
    public void setUp() {
        array = new Array(5);
        arr = new Array(5);
    }

    @Test
    public void ArrayLisäysToimii() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        int size = array.getSize();
        assertEquals(5, size);
        int a = array.get(0);
        assertEquals(0, a);
        a = array.get(1);
        assertEquals(1, a);
        a = array.get(2);
        assertEquals(2, a);

        a = array.get(4);
        assertEquals(4, a);
        array.add(5);
        size = array.getSize();
        assertEquals(5, size);
    }

    @Test
    public void duplikaattejaEiLisata() {
        array.add(1);
        int size = array.getSize();
        assertEquals(1, size);
        array.add(1);
        size = array.getSize();
        assertEquals(1, size);
        array.add(2);
        size = array.getSize();
        assertEquals(2, size);
    }
    
    @Test
    public void gettausToimiiOikein(){ //integerien kanssa tulee ongelmia nullien kanssa, siksi vertex-array testeihin tässä
        Vertex[] list = new Vertex[5];
        for (int i  = 0; i< 5; i++){
            list[i] = new Vertex(0, i);
            arr.add(list[i]);
        }
        Vertex a = arr.get(4);
        assertEquals(list[4], a);
        a = arr.get(5);
        assertEquals(null, a);
        a = arr.get(-1);
        assertEquals(null, a);
    }

}