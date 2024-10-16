package pieces;

import chessgame.ChessBoard;

public class King extends Piece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board) {
        int dx = Math.abs(toX - fromX);
        int dy = Math.abs(toY - fromY);
        return (dx <= 1 && dy <= 1); // Kungen kan bara röra sig ett steg i alla riktningar
    }
    @Override
    public String getInitial() {
        return "K"; //  king med 'K'
    }
}
