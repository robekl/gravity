package gravity.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphaPieceTest {
    @Test
    public void squaresAndRows() {
        Piece z = new AlphaPiece(0);
        assertEquals(4, z.countSquares());
        assertEquals(1, z.getRows().size());
    }
}