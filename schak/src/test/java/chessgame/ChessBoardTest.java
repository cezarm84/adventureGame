package chessgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    private ChessBoard chessBoard;

    @BeforeEach
    void setUp() {
        chessBoard = new ChessBoard();
        chessBoard.resetBoard();  // Initialize the board
    }

    @Test
    void testGetTile() {
        assertNotNull(chessBoard.getTile(1, 1)); // Should not be null for a Rock
        assertNull(chessBoard.getTile(3, 3)); // Should be null for an empty square
    }

    @Test
    void testSetTile() {
        Piece newPiece = new Pawn("White");
        chessBoard.setTile(3, 3, newPiece);
        assertEquals(newPiece, chessBoard.getTile(3, 3)); // Check if piece was set correctly
    }

    @Test
    void testCanMove() {
        assertTrue(chessBoard.canMove(1, 2, 1, 3)); // Pawn can move forward
        assertFalse(chessBoard.canMove(1, 2, 1, 5)); // Invalid move for Pawn
    }

    @Test
    void testPrintBoard() {
        chessBoard.printBoard(); // Just testing the print function
    }
}
