package reittitemp;

/*
verkon solmujen toteutus
 */
public class Node {

    protected Node[] neighbours;
    protected int nodes;
    protected int color; //0=ei tutkittu, 1 = tutkittu
    protected int distance;

    public Node() {
        //naapureita voi olla maksimissaan 4 ruudukossa (vertikaalinen ja horisontaalinen liike)
        neighbours = new Node[4];
        nodes = 0;
        color = 0;
        distance = 99999;
    }

    //lisätään solmulle naapuri
    public void addNode(Node n) {
        int i = 0;
        while (i < neighbours.length) {
            if (neighbours[i] == null) {
                neighbours[i] = n;
                break;
            }
            i++;
        }

    }

    public void connect(Node n) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (neighbours[i] == n) {
                temp++;
                break;
            }
        }
        if (temp == 0) {
            neighbours[nodes++] = n;
            n.connect(this);
        }
    }

    public void visit() {
        color = 1;
    }

    public Node[] getNeighbours() {
        return neighbours;
    }
}
