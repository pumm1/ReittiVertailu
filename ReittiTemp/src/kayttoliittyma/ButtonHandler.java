package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import reittitemp.Algorithm;
import reittitemp.Graph;
import reittitemp.Node;

public class ButtonHandler implements ActionListener {

    private Graph graph;
    private Kayttoliittyma ui;
    private Algorithm algorithm;

    public ButtonHandler(Graph g, Kayttoliittyma k) {
        graph = g;
        ui = k;
//        algorithm = a;
    }

    public void setAlgorithm(Algorithm a) {
        algorithm = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        graph.initGraph();
//        Object source = e.getSource();
        Node s = graph.getS();
        if (graph.getS() != null) {
            System.out.println("s not null..");
            if (graph.getU() != null) {
                System.out.println("u not null..");
                System.out.println("drawing route");
                HashMap<Node, Node> tree = algorithm.findRoute(s);
                Node u = graph.getU();
                u = tree.get(u);
                if(u != null){
                    System.out.println("u not null");
                }
                graph.printGraph();
                ui.drawRoute(tree, s, u);
            }
        }
        System.out.println("diu diu!");
    }

}
