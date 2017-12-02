
package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import reittitemp.Algorithm;
//import reittitemp.Graph;
import reittitemp.Vertex;
import reittitemp.Verkko;

public class ButtonHandler implements ActionListener {

//    private Graph graph;
    private Verkko verkko;
    private Kayttoliittyma ui;
    private Algorithm algorithm;

    public ButtonHandler(Verkko v, Kayttoliittyma k) {
        verkko = v;
        ui = k;
//        algorithm = a;
    }

//    public ButtonHandler(Graph g, Kayttoliittyma k) {
//        graph = g;
//        ui = k;
////        algorithm = a;
//    }

    public void setAlgorithm(Algorithm a) {
        algorithm = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        verkko.initGraph();
//        Object source = e.getSource();
        Vertex s = verkko.getS();
        if (verkko.getS() != null) {
//            System.out.println("s not null..");
            if (verkko.getU() != null) {
//                System.out.println("u not null..");
//                System.out.println("drawing route");
                algorithm.findRoute(s);
                Vertex u = verkko.getU();
//                u = tree.get(u);
                u = u.getPrev();
                if (u != null) {
                    System.out.println("u not null");
                }
//                graph.printGraph();
                ui.drawRoute(s, u);
            }
        }
        System.out.println("diu diu!");
    }

}