package reittitemp;

public class Heap {

    //pinon toteutus ainakin Dijkstran algoritmia varten
    private Node[] nodes;
    private int nCount;

    public Heap() {
        nodes = new Node[2500];
        nCount = 0;
    }

    public int getCount() {
        return nCount;
    }

    public Node[] getNodes() {
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
        Node a = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = a;
    }

    public void insertNode(Node n) {
        int i = nCount;
        nCount++;

        while (i > 0 && nodes[parent(i)].getDist() > n.getDist()) {

            nodes[i] = nodes[parent(i)];
            i = parent(i);
        }

        nodes[i] = n;

    }

    public Node delMin() {
        Node n = nodes[0];
        if (nCount > 0) {
            nCount--;
        }
//        System.out.println("nCount: " + nCount);
//        System.out.println("nodes.len: " + nodes.length);
        int a = 0;
        for (Node i : nodes) {
            if (i == null) {
                break;
            }
            a++;

        }
//        System.out.println("a: " + a);
//        System.out.println("ncount: " + nCount);
        nodes[0] = nodes[nCount];
        heapify(0);
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
