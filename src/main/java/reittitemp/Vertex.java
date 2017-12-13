package main.java.reittitemp;

public class Vertex {

    /**
     *@param id noden id
     *@param x x-koordinaatti
     *@param y y-koordinaatti
     *@param neighbours naapurit
     *@param nodes määrä nodeja naapureissa 
     *@param color viestii onko node tutkittu
     *@param distance etäisyys s:stä
     *@param prev edellinen node
     *@param index indeksi
     */
    protected int id;
    protected int x;
    protected int y;
    protected Vertex[] neighbours;
    protected int nodes; //amount of neighbours, max = 4
    protected int color; //0=ei tutkittu, 1 = tutkittu
    protected int distance;
    private Vertex prev; //mahdollinen ratkaisu hahsmapin korvaamiselle? ei ehkä toimi
    private int index;

    
    /**
     *@param a x:n arvo
     *@param b y:n arvo
     */
    public Vertex(int a, int b) {
        id = 2;
        x = a;
        y = b;
        neighbours = new Vertex[4];
        nodes = 0;
        color = 0;
        distance = 99999;
        index = 0;
    }

    /**
     *@param i indeksi
     */
    public void setIndex(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    /**
     *@param i id
     *@param a
     *@param b
     */
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


    public void setDist(int d) {
        distance = d;
    }

    /**
     *relaksaation toteutus Dijkstraa varten
     *@param v node, johon verrataan
     */
    public int relax(Vertex v) {
        int ret = -1;
        for (int i = 0; i < 4; i++) {
            if (neighbours[i] == v) {
                if (v != null) {
                    if (v.getDist() > distance + 1) {
                        ret = v.getDist();
                        v.setDist(distance + 1);
                        v.setPrev(this);
                    }
                }
                break;
            }
        }
        return ret;
    }

    public int getColor() {
        return color;
    }

    /**
     *@param n yhdistä node tähän
     */
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

    
    /**
     *@param i distancen uusi arvo tämän mukaan
     */
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

    /**
     *@param i uusi prev
     */
    public void setPrev(Vertex i) {
        prev = i;
    }

    public Vertex getPrev() {
        return prev;
    }
}