package gravity.components;

/**
 * Horizontal collection of "empty" or "occupied" squares.
 * Represented as a bitmap corresponding to the position of each square
 * from the left side of the grid.
 * A collection of Rows is used by the grid and by each shape.
 */
public class Row {
    // "The grid of the game space is 10 units wide"
    public static int MAX_COLUMNS = 10;

    protected int occupied = 0;

    /**
     * construct an empty row
     */
    public Row() {
    }

    /**
     * construct a row with a variable number of squares occupied
     */
    public Row(int offset, boolean... squares) {
        int bitPosition = 1;
        for (boolean square : squares) {
            occupied |= (square ? bitPosition << offset : 0);
            bitPosition <<= 1;
        }
    }

    /**
     * no squares?
     */
    boolean isEmpty() {
        return occupied == 0;
    }

    /**
     * all squares?
     */
    boolean isFull() {
        return occupied == (1 << MAX_COLUMNS) - 1;
    }

    /**
     * include in this row, all squares in the other row
     */
    void combineRow(Row other) {
        this.occupied |= other.occupied;
    }

    /**
     * do any squares "overlap" between this row and the other row?
     */
    boolean isCollision(Row other) {
        return (this.occupied & other.occupied) != 0;
    }

    public String dump() {
        StringBuilder dump = new StringBuilder();
        int remaining = occupied;
        while (remaining > 0) {
            dump.append(((remaining & 1) != 0) ? "O" : "_");
            remaining >>= 1;
        }
        return dump.append('\n').toString();
    }

    /**
     * unit test helper
     */
    public int bitCount() {
        return Integer.bitCount(occupied);
    }
}
