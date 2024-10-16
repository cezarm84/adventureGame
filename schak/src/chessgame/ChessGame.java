package chessgame;

import pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.resetBoard();
        board.printBoard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till Schack!");
        System.out.println("Ange drag i formatet: fromX fromY toX toY");

        while (true) {
            System.out.print("Ditt drag: ");
            int fromX = scanner.nextInt();
            int fromY = scanner.nextInt();
            int toX = scanner.nextInt();
            int toY = scanner.nextInt();

            // Kontrollera om det finns en pjäs på fromX, fromY
            Piece selectedPiece = board.getTile(fromX, fromY);

            if (selectedPiece == null) {
                System.out.println("Ingen pjäs på den positionen. Försök igen.");
                continue;
            }

            // Skriv ut vilken pjäs som försöker flyttas
            System.out.println("Flyttar: " + selectedPiece.getClass().getSimpleName() + " (" + selectedPiece.getColor() + ")");

            // Kontrollera om draget är giltigt
            if (board.canMove(fromX, fromY, toX, toY)) {
                board.setTile(toX, toY, selectedPiece);
                board.setTile(fromX, fromY, null);
                System.out.println("Drag utfört.");
            } else {
                System.out.println("Ogiltigt drag. Försök igen.");
            }
        }
    }
}
