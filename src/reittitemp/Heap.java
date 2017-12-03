package reittitemp;

public class Heap {

    //pinon toteutus ainakin Dijkstran algoritmia varten
    private Vertex[] nodes;
    private int nCount;
    private int size;

    public Heap() {
        nodes = new Vertex[2500];
        nCount = 0;
        size = 2500;
    }

    public Heap(int i) {
        if (i > 0) {
            nodes = new Vertex[i];
            size = i;
        } else {
            nodes = new Vertex[2500];
            size = 2500;
        }
        nCount = 0;
    }

    public int getCount() {
        return nCount;
    }

    public int getSize() {
        return size;
    }

    public Vertex[] getNodes() {
        return nodes;
    }

    public Vertex getNodeFrom(int i) {
        if (i < nCount) {
            return nodes[i];
        }
        return null;
    }
    
    public void moveUp(int i){
        if(nodes[parent(i)].getDist() > nodes[i].getDist()){
            swap(parent(i), i);
            moveUp(parent(i));
        }
    }

    public void decKey(Vertex v) {
        moveUp(v.getIndex());
//        heapify(v.getIndex());
//        insertNode(v);
    }

    //tää jää looppiin?
    public void heapify(int i) {
        int smallest;
        int l = left(i);
        int r = right(i);
        if (r < nCount) {
            if (nodes[l].getDist() < nodes[r].getDist()) {
                smallest = l;
            } else {
                smallest = r;
            }
            if (nodes[i].getDist() > nodes[smallest].getDist()) {
                swap(i, smallest);
                heapify(smallest);
            }
        } else if (l == nCount - 1 && nodes[i].getDist() > nodes[l].getDist()) {
            swap(i, l);
        }
    }

    public void swap(int i, int j) {
        nodes[i].setIndex(j);
        nodes[j].setIndex(i);
        Vertex a = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = a;
    }

    public void insertNode(Vertex n) {
        int i = nCount;
        nCount++;

        while (i > 0 && nodes[parent(i)].getDist() > n.getDist()) {

            nodes[i] = nodes[parent(i)];
            i = parent(i);
        }

        nodes[i] = n;
        n.setIndex(i);

    }

    public boolean isEmpty() {
        if (nCount == 0) {
            return true;
        }
        return false;
    }

    public Vertex delMin() {
        Vertex n;
        if (nCount > 0) {
            n = nodes[0];
            nodes[0] = nodes[nCount - 1];
            nCount--;
            heapify(0);
        } else {
            n = null;
        }

        return n;
    }

    public int parent(int i) {
        int r;
        if (i < 3) {
            return 0;
        } else {
            if (i % 2 == 0) {
                r = (int) Math.floor(i / 2) - 1;
                return r;
            } else {
                r = (int) Math.floor(i / 2);
                return r;
            }
        }
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

}
