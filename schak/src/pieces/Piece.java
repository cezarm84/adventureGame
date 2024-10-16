package pieces;

import chessgame.ChessBoard;

public abstract class Piece {
    protected String color;  // "White" eller "Black"

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board);
    public abstract String getInitial();
}
