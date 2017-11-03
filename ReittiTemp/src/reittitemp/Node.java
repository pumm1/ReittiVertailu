package reittitemp;

/*
verkon solmujen toteutus
 */
public class Node {

    protected Node[] neighbours;

    public Node() {
        //naapureita voi olla maksimissaan 4 ruudukossa (vertikaalinen ja horisontaalinen liike)
        neighbours = new Node[4]; 

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
    
    public Node[] getNeighbours(){
        return neighbours;
    }
}
