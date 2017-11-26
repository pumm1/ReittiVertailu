package reittitemp;

public class Edge {

    private Vertex source;
    private Vertex destination;
    private int id;
    private int weight;

    public Edge(int id, Vertex s, Vertex d, int w) {
        id = id;
        source = s;
        destination = d;
        weight = w;
    }
    
    public void changeWeight(int w){
        weight = w;
    }

    public int getId() {
        return id;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }
}
