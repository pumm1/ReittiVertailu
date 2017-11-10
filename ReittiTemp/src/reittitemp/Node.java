package reittitemp;

/*
verkon solmujen toteutus
 */
public class Node {

    protected int x;
    protected int y;
    protected Node[] neighbours;
    protected int nodes; //amount of neighbours, max = 4
    protected int color; //0=ei tutkittu, 1 = tutkittu
    protected int distance;

    public Node(int a, int b) {
        x = a;
        y = b;
        //naapureita voi olla maksimissaan 4 ruudukossa (vertikaalinen ja horisontaalinen liike)
        neighbours = new Node[4];
        nodes = 0;
        color = 0;
        distance = 99999;
    }

//tuli vahingossa tehtyä kaksi naapurien lisäämisene liittyvää metodia, komementoidaan turha pois alustavasti
//    public void addNode(Node n) {
//        int i = 0;
//        while (i < neighbours.length) {
//            if (neighbours[i] == null) {
//                neighbours[i] = n;
//                break;
//            }
//            i++;
//        }
//
//    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    //lisätään solmulle naapuri
    public void connect(Node n) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (neighbours[i] == n) {
                temp++;
                break;
            }
        }
        if (nodes < 3) {
            if (temp == 0) {
                neighbours[nodes++] = n;
                n.connect(this);
            }
        }

    }

    public int getDist() {
        return distance;
    }

    public void visit() {
        color = 1;
    }

    public Node[] getNeighbours() {
        return neighbours;
    }
}
