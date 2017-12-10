


import java.util.Random;
import ui.Kayttoliittyma;

public class Main {

   public static void main(String[] args) {
        Random r = new Random();
        int grid[][] = new int[50][50];
        
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                int temp = r.nextInt(100);
                if (temp > 55) {
                    grid[i][j] = 1;
                }
            }
        }
        Kayttoliittyma ui = new Kayttoliittyma(grid);
        
    }
    
}
