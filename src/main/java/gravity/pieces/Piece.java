package gravity.pieces;

import gravity.components.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of four squares that go on the grid.
 * Here, the Piece comprises Rows with the location of the squares.
 * Similar to the Grid, the Rows are ordered with the first entry in the
 * List as the lowest as thought of on a traditional board.
 */
public abstract class Piece {
    protected final List<Row> rows = new ArrayList<>();

    public List<Row> getRows() {
        return rows;
    }

    public int getNumberOfRows() {
        return rows.size();
    }

    /**
     * unit test helper
     */
    int countSquares() {
        return rows.stream().map(Row::bitCount).reduce(0, Integer::sum);
    }
}
