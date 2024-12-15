package gravity.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetaPieceTest {
    @Test
    public void squaresAndRows() {
        Piece z = new BetaPiece(0);
        assertEquals(4, z.countSquares());
        assertEquals(3, z.getRows().size());
    }
}