package pieces;

import chessgame.ChessBoard;

public class Pawn extends Piece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromX, int fromY, int toX, int toY, ChessBoard board) {
        // Kontrollera om bonden rör sig framåt en ruta
        if (this.getColor().equals("White")) {
            // Vit bonde rör sig uppåt
            // Kontrollera två rutor framåt från startposition (y = 2)
            if (fromY == 2 && toY == fromY + 2 && fromX == toX && board.getTile(toX, toY) == null &&
                    board.getTile(fromX, fromY + 1) == null) {
                return true; // Kan flytta två rutor framåt från startposition
            }
            // Kontrollera en ruta framåt
            if (toY == fromY + 1 && fromX == toX && board.getTile(toX, toY) == null) {
                return true; // En ruta framåt
            }
        } else {
            // Svart bonde rör sig nedåt
            // Kontrollera två rutor framåt från startposition (y = 7)
            if (fromY == 7 && toY == fromY - 2 && fromX == toX && board.getTile(toX, toY) == null &&
                    board.getTile(fromX, fromY - 1) == null) {
                return true; // Kan flytta två rutor framåt från startposition
            }
            // Kontrollera en ruta framåt
            if (toY == fromY - 1 && fromX == toX && board.getTile(toX, toY) == null) {
                return true; // En ruta framåt
            }
        }

        // Om inget av villkoren är uppfyllt, är draget ogiltigt
        return false;
    }
    @Override
    public String getInitial() {
        return "P"; //  bonde med 'P'
    }
}

