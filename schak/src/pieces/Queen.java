package pieces;

import chessgame.ChessBoard;

public class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board) {
        int dx = Math.abs(toX - fromX);
        int dy = Math.abs(toY - fromY);
        return (dx == dy || fromX == toX || fromY == toY); // queen kan röra sig diagonalt, horisontellt eller vertikalt
    }
    @Override
    public String getInitial() {
        return "Q"; //  queen med 'q'
    }
}
