package reittitemp;

import java.util.HashMap;

public class ReittiTemp {

    public static void main(String[] args) {

        int grid[][] = new int[50][50];
        grid[1][0] = 1;
        grid[1][1] = 1;
        int i = 0;

        Graph graph = new Graph(grid);
        graph.initGraph();
        Node nGrid[][] = graph.getNodeGrid();
        Node s = nGrid[0][0];
        HashMap<Node, Node> tree = graph.BFS(s);
        graph.printGraph();
        Node u = tree.get(nGrid[2][2]);

        System.out.println("finding route to (2,2) from (0,0)");
//        System.out.println("u.x: " + u.getX() + ", u.y: " + u.getY());
        while (u != s) {
            System.out.println("**********");
            System.out.println("u.x: " + u.getX() + ", u.y: " + u.getY());
//            System.out.println("**********");
            u = tree.get(u);
        }
        System.out.println("u.x: " + u.getX() + ", u.y: " + u.getY());
    }

}
