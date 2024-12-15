package gravity.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeltaPieceTest {
    @Test
    public void squaresAndRows() {
        Piece z = new DeltaPiece(0);
        assertEquals(4, z.countSquares());
        assertEquals(2, z.getRows().size());
    }
}