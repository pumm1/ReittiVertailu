package reittitemp;

public class Heap {

    //pinon toteutus ainakin Dijkstran algoritmia varten
    private Vertex[] nodes;
    private int nCount;

    public Heap() {
        nodes = new Vertex[2500];
        nCount = 0;
    }

    public int getCount() {
        return nCount;
    }

    public Vertex[] getNodes() {
        return nodes;
    }

    //tää jää looppiin?
    public void heapify(int i) {
        int smallest;
        int l = left(i);
        int r = right(i);
        if (r <= nCount) {
            if (nodes[l].getDist() < nodes[r].getDist()) {
                smallest = l;
            } else {
                smallest = r;
            }
            if (nodes[i].getDist() > nodes[smallest].getDist()) {
                swap(i, smallest);
                heapify(smallest);
            }
        } else if (l == nCount && nodes[i].getDist() > nodes[l].getDist()) {
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
        Vertex n = nodes[0];
        if (nCount > 0) {
            nCount--;
        }
//        System.out.println("nCount: " + nCount);
//        System.out.println("nodes.len: " + nodes.length);
        int a = 0;
        for (Vertex i : nodes) {
            if (i == null) {
                break;
            }
            a++;

        }
//        System.out.println("a: " + a);
//        System.out.println("ncount: " + nCount);
        nodes[0] = nodes[nCount];
        heapify(0);
//        System.out.println(n.id() + ".w:" + n.getDist());
        return n;
    }

    public void dec(Vertex v) {
//        int i = 0;
//        while(i < 2500){
//            if(nodes[i] == v){
//                heapify(i);
//                break;
//            }
//            i++;
//        }
        heapify(v.getIndex());
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
