
package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import reittitemp.Algorithm;
import reittitemp.Array;
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
        long alku = System.currentTimeMillis();
        long loppu;
        verkko.initGraph();
        Vertex s = verkko.getS();
        if (verkko.getS() != null) {

            if (verkko.getU() != null) {

                algorithm.findRoute(s);
                Vertex u = verkko.getU();

                u = u.getPrev();
                if (u != null) {
                }
                ui.drawRoute(s, u);
             loppu = System.currentTimeMillis();
                System.out.println("aikaa meni: " + (loppu - alku) + " ms");
            }
        }
        
    }
    /*
    AIKOJA (ms):
    BFS: 8, 5, 6, 5, 4, 11, 7, 5, 3, 3, 6, 3, 4, 6, 5
    DFS: 5, 5, 6, 4, 4, 5, 5, 7, 2, 4, 5, 2, 3, 8, 8
    Dijkstra: 11, 8, 10, 10, 9, 8, 6, 6, 11, 8, 3, 5
    */

}