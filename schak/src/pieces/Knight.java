package pieces;

import chessgame.ChessBoard;

public class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board) {
        int dx = Math.abs(toX - fromX);
        int dy = Math.abs(toY - fromY);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2); // Springaren rör sig i ett "L"-format
    }
    @Override
    public String getInitial() {
        return "N"; //  knight med 'n
    }
}
