package reittitemp;

import java.util.*;
import kayttoliittyma.Kayttoliittyma;

public class ReittiTemp {

    public static void main(String[] args) {

        Random r = new Random();
        int grid[][] = new int[50][50];
//        grid[1][0] = 1;
//        grid[1][1] = 1;
        int i = 0;
        int x = 0;
        int y = 0;
//        while (i < 200) {
//            x = r.nextInt(50);
//            y = r.nextInt(50);
//            if (!(x == 0 && y == 0) && !(x == 30 && y == 30)) {
//                grid[x][y] = 1;
//                i++;
//            }
//        }
        Graph graph = new Graph(grid);
        graph.initGraph();
        Node nGrid[][] = graph.getNodeGrid();
//        Node s = nGrid[0][0];
//        Node s;
//        while (true) {
//            x = r.nextInt(50);
//            y = r.nextInt(50);
//            if (grid[x][y] == 0) {
//                s = nGrid[x][y];
//                break;
//            }
//        }
//        
        Bfs BFS = new Bfs(graph);
//        HashMap<Node, Node> tree = BFS.findRoute(s);
//        graph.printGraph();
        Node u;
//        while (true) {
//            x = r.nextInt(50);
//            y = r.nextInt(50);
//            if (grid[x][y] == 0) {
//                u = tree.get(nGrid[x][y]);
//                break;
//            }
//        }
//        u = tree.get(nGrid[30][30]);

        Kayttoliittyma ui = new Kayttoliittyma(grid);
//        ui.drawRoute(tree, s, u);

//        System.out.println("finding route to (2,2) from (0,0)");
////        System.out.println("u.x: " + u.getX() + ", u.y: " + u.getY());
//        while (u != s) {
//            System.out.println("**********");
//            System.out.println("u.x: " + u.getX() + ", u.y: " + u.getY());
////            System.out.println("**********");
//            u = tree.get(u);
//        }
//        System.out.println("u.x: " + u.getX() + ", u.y: " + u.getY());
    }

}
