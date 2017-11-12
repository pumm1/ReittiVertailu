package kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma extends JFrame implements KeyListener {

    private JButton[][] squares;
    private Container contents;
    private ButtonHandler buttonHandler;
    private int[][] grid;

    public Kayttoliittyma(int[][] g) {
        super("ReittiVertailu");
        grid = g;
        squares = new JButton[50][50];
        contents = getContentPane();
        contents.setLayout(new GridLayout(50, 50));
        buttonHandler = new ButtonHandler(squares);
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                squares[i][j] = new JButton();
                if(grid[i][j] == 0){
                    squares[i][j].setBackground(Color.white);
                }else{
                    squares[i][j].setBackground(Color.black);
                }
                contents.add(squares[i][j]);
                squares[i][j].addActionListener(buttonHandler);
                squares[i][j].addKeyListener(this);
            }
        }
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
