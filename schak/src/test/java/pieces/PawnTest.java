package pieces;

import chessgame.ChessBoard;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    @Test
    public void testValidMoveOneStepForward() {
        ChessBoard board = new ChessBoard();
        board.resetBoard();
        Pawn pawn = new Pawn("White");

        assertTrue(pawn.isValidMove(1, 2, 1, 3, board));  // One step forward
    }

    @Test
    public void testInvalidMoveBackwards() {
        ChessBoard board = new ChessBoard();
        board.resetBoard();
        Pawn pawn = new Pawn("White");

        assertFalse(pawn.isValidMove(1, 2, 1, 1, board));  // Can't move backward
    }
}
