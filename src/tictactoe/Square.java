package tictactoe;

import javax.swing.JButton;

/**
 *
 * @author Anton
 */
public class Square extends JButton {

    private boolean occupied = false;

    public Square() {
        initComponent();
    }

    private void initComponent() {
        setFont(getFont().deriveFont(18.0f));
    }

    public String getSymbol() {
        return getText();
    }

    public void setSymbol(String symbol) {
        setText(symbol);
        setOccupied(true);
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
