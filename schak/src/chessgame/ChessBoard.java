package chessgame;

import pieces.*;

public class ChessBoard {
    private Piece[][] board = new Piece[8][8];

    public Piece getTile(int x, int y) {
        if (isValidCoordinate(x, y)) {
            return board[y - 1][x - 1];
        }
        return null;
    }

    public void setTile(int x, int y, Piece piece) {
        if (isValidCoordinate(x, y)) {
            board[y - 1][x - 1] = piece;
        }
    }

    public boolean canMove(int fromX, int fromY, int toX, int toY) {
        if (isValidCoordinate(fromX, fromY) && isValidCoordinate(toX, toY)) {
            Piece piece = getTile(fromX, fromY);

            if (piece != null) {
                return piece.isValidMove(fromX, fromY, toX, toY, this);
            } else {
                System.out.println("No piece at (" + fromX + ", " + fromY + ")");
            }
        } else {
            System.out.println("Invalid coordinates.");
        }
        return false;
    }

    public void resetBoard() {
        board = new Piece[8][8];  // Nollställa bordet

        // Placera vita pjäser 1:a raden för större pjäser, 2:a raden för bönder
        board[0][0] = new Rock("White");
        board[0][1] = new Knight("White");
        board[0][2] = new Bishop("White");
        board[0][3] = new Queen("White");
        board[0][4] = new King("White");
        board[0][5] = new Bishop("White");
        board[0][6] = new Knight("White");
        board[0][7] = new Rock("White");

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("White");  // Placera vita bönder
        }

        // Placera svarta pjäser 8 raden för större pjäser, 7:e raden för bönder
        board[7][0] = new Rock("Black");
        board[7][1] = new Knight("Black");
        board[7][2] = new Bishop("Black");
        board[7][3] = new Queen("Black");
        board[7][4] = new King("Black");
        board[7][5] = new Bishop("Black");
        board[7][6] = new Knight("Black");
        board[7][7] = new Rock("Black");

        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("Black");  //  svarta bönder
        }
    }


    private boolean isValidCoordinate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
    public void printBoard() {
        System.out.println("   a  b  c  d  e  f  g  h");
        System.out.println(" + ----------------");
        for (int y = 7; y >= 0; y--) {
            System.out.print(y + 1 + "|"); // Skriv ut radnummer
            for (int x = 0; x < 8; x++) {
                Piece piece = board[x][y];
                if (piece != null) {
                    // Skriv ut initialen för pjäsen
                    if (piece.getColor().equals("White")) {
                        System.out.print(" " + piece.getInitial() + " "); // Vit pjäs
                    } else {
                        System.out.print(" " + piece.getInitial().toLowerCase() + " "); // Svart pjäs
                    }
                } else {
                    System.out.print(" . "); // Tom ruta
                }
            }
            System.out.println("|" + (y + 1)); // Avsluta raden med radnummer
        }
        System.out.println(" +----------------");
        System.out.println("y->1  2  3  4  5  6  7  8");
    }
}
