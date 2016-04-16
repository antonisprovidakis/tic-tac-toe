package tictactoe;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Anton
 */
public class TicTacToeFrame extends JFrame {
    
    private TicTacToe triliza;
    
    public TicTacToeFrame() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        triliza = new TicTacToe();
        
        add(triliza, BorderLayout.CENTER);
        
    }
}
