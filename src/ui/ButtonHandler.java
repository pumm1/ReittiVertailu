package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reittitemp.Algorithm;
import reittitemp.Vertex;
import reittitemp.Verkko;

public class ButtonHandler implements ActionListener {

    private Verkko verkko;
    private Kayttoliittyma ui;
    private Algorithm algorithm;

    /**
     *@param v verkon parametri
     *@param k käyttöliittymän parametri
     */
    public ButtonHandler(Verkko v, Kayttoliittyma k) {
        verkko = v;
        ui = k;
    }

    /**
     *@param a seuraava algoritmi
     */
    public void setAlgorithm(Algorithm a) {
        algorithm = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long alku = System.currentTimeMillis();
        long loppu;
        long aika;
        verkko.initGraph();
        Vertex s = verkko.getS();
        if (verkko.getS() != null) {
            if (verkko.getU() != null) {
                algorithm.findRoute(s);
                Vertex u = verkko.getU();
                u = u.getPrev();
                if (u != null) {
                }
                loppu = System.currentTimeMillis();
                aika = loppu - alku;
                System.out.println("aikaa meni: " + aika + " ms");
                ui.drawRoute(s, u, aika);
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
