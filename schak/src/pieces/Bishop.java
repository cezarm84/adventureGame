package pieces;

import chessgame.ChessBoard;

public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board) {
        int dx = Math.abs(toX - fromX);
        int dy = Math.abs(toY - fromY);
        return dx == dy; // bishop kan bara röra sig diagonalt
    }
    @Override
    public String getInitial() {
        return "B";
    }
}
