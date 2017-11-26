package reittitemp;

/*
verkon solmujen toteutus
 */
public class Vertex {

    protected int id;
    protected int x;
    protected int y;
    protected Vertex[] neighbours;
    protected int nodes; //amount of neighbours, max = 4
    protected int color; //0=ei tutkittu, 1 = tutkittu
    protected int distance;
    private Vertex prev; //mahdollinen ratkaisu hahsmapin korvaamiselle? ei ehkä toimi
    private Vertex next;
    private int index;

    public Vertex(int a, int b) {
        id = 2;
        x = a;
        y = b;
        //naapureita voi olla maksimissaan 4 ruudukossa (vertikaalinen ja horisontaalinen liike)
//        neighbours = new Node[8]; //4
        neighbours = new Vertex[4];
        nodes = 0;
        color = 0;
        distance = 99999;
        index = 0;
    }

    public void setIndex(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public Vertex(int i, int a, int b) {
        id = i;
        x = a;
        y = b;
        //naapureita voi olla maksimissaan 4 ruudukossa (vertikaalinen ja horisontaalinen liike)
        neighbours = new Vertex[4];
        nodes = 0;
        color = 0;
        distance = 99999;
    }

    public int id() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void printNeighbours() {
        for (Vertex i : neighbours) {
            System.out.println("----");
            System.out.println("(" + i.getX() + ", " + i.getY() + ")");
        }
    }

    public void setDist(int d) {
        distance = d;
    }

    public void relax(Vertex v) {
        for (int i = 0; i < 4; i++) {
            if (neighbours[i] == v) {
                if (v != null) {
                    if (v.getDist() > distance + 1) {
                        v.setDist(distance + 1);
//                        System.out.println(id + " distance to " + n.id() + ": " + distance);
                        System.out.println(v.id + " distance changed in relax to " + id + ", new dist: " + distance + 1);
//                        n.setPrev(this);
                        System.out.println(v.id() + " prev: " + id());
                        v.setPrev(this);
                    }
                }
                break;
            }
        }
    }

    public int getColor() {
        return color;
    }

    //lisätään solmulle naapuri
    public void connect(Vertex n) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (neighbours[i] == n) {
                temp++;
                break;
            }
        }
        if (nodes < 4) {
            if (temp == 0) {
                neighbours[nodes++] = n;
                n.connect(this);
            }
        }

    }

    public void reset() {
        prev = null;
        color = 0;
        distance = 99999;
    }

    public void start() {
        distance = 0;
        visit();
    }

    public void incDist(int i) {
        distance = i + 1;
    }

    public int getDist() {
        return distance;
    }

    public void visit() {
        color = 1;
    }

    public Vertex[] getNeighbours() {
        return neighbours;
    }

    public void setPrev(Vertex i) {
        prev = i;
    }

    public Vertex getPrev() {
        return prev;
    }
}
