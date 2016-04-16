package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anton
 */
public class TicTacToe extends JPanel {

    private Square[] board;
    private JPanel boardPanel;

    private JLabel labelWinner;

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private int round = 1;

    private boolean gameOver = false;

    public TicTacToe() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        board = new Square[9];

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));

        TrilizaListener tbl = new TrilizaListener();

        for (int i = 0; i < board.length; i++) {
            board[i] = new Square();
            board[i].addActionListener(tbl);
            boardPanel.add(board[i]);
        }

        add(boardPanel, BorderLayout.CENTER);

        labelWinner = new JLabel();
        labelWinner.setPreferredSize(new Dimension(labelWinner.getSize().width, 20));
        add(labelWinner, BorderLayout.NORTH);

        player1 = new Player("X");
        currentPlayer = player1;
        player2 = new Player("O");

    }

    private void nextRound() {
        round += 1;

        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {
        boolean winnerFound = false;

        if ((board[0].isOccupied() && board[0].getSymbol().equals(board[1].getSymbol()) && board[0].getSymbol().equals(board[2].getSymbol()))
                || (board[3].isOccupied() && board[3].getSymbol().equals(board[4].getSymbol()) && board[3].getSymbol().equals(board[5].getSymbol()))
                || (board[6].isOccupied() && board[6].getSymbol().equals(board[7].getSymbol()) && board[6].getSymbol().equals(board[8].getSymbol()))
                || (board[0].isOccupied() && board[0].getSymbol().equals(board[3].getSymbol()) && board[0].getSymbol().equals(board[6].getSymbol()))
                || (board[1].isOccupied() && board[1].getSymbol().equals(board[4].getSymbol()) && board[1].getSymbol().equals(board[7].getSymbol()))
                || (board[2].isOccupied() && board[2].getSymbol().equals(board[5].getSymbol()) && board[2].getSymbol().equals(board[8].getSymbol()))
                || (board[0].isOccupied() && board[0].getSymbol().equals(board[4].getSymbol()) && board[0].getSymbol().equals(board[8].getSymbol()))
                || (board[2].isOccupied() && board[2].getSymbol().equals(board[4].getSymbol()) && board[2].getSymbol().equals(board[6].getSymbol()))) {

            winnerFound = true;
        }

        return winnerFound;
    }

    private class TrilizaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Square square = (Square) e.getSource();

            if (!square.isOccupied() && !gameOver && round <= 9) {

                square.setSymbol(currentPlayer.getSymbol());

                if (hasWinner()) {
                    gameOver = true;
                    labelWinner.setText("Winner is Player: " + currentPlayer.getSymbol());
                } else if (round == 9) {
                    System.out.println("This is a Draw");
                }

                nextRound();
            }
        }
    }
}
