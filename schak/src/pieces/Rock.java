package pieces;


import chessgame.ChessBoard;

public class Rock extends Piece {
    public Rock(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board) {
        return fromX == toX || fromY == toY; // Tornet rör sig bara horisontellt eller vertikalt
    }
    @Override
    public String getInitial() {
        return "R"; //  rock med 'R'
    }
}
