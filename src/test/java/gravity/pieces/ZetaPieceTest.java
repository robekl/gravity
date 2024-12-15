package gravity.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZetaPieceTest {
    @Test
    public void squaresAndRows() {
        Piece z = new ZetaPiece(0);
        assertEquals(4, z.countSquares());
        assertEquals(2, z.getRows().size());
    }
}