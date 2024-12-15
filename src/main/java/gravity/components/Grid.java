package gravity.components;

import gravity.engine.ConsolePrinter;
import gravity.pieces.Piece;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Contains the grid, which is a List of Rows.
 * The initial row (index 0) is at the bottom, as one would think of a traditional grid.
 * When a Row is added, it is added to the end of the list, so it's index is one greater than the last Row.
 */
public class Grid {
    private final List<Row> gridRows = new ArrayList<>();

    public void addEmptyRow() {
        gridRows.add(new Row());
    }

    public void addEmptyRows(int numRows) {
        for (int i = 0; i < numRows; i++) {
            gridRows.add(new Row());
        }
    }

    public void removeEmptyRows() {
        gridRows.removeIf(Row::isEmpty);
    }

    public void removeFullRows() {
        gridRows.removeIf(Row::isFull);
    }

    public int getHeight() {
        return gridRows.size();
    }

    /**
     * determine where new piece goes, based on typical rules
     * (gravity, collisions)
     * @param piece the new piece being added to the grid
     */
    public void addPieceToGrid(Piece piece) {
        // ensure there's always somewhere to put the new piece
        addEmptyRows(piece.getNumberOfRows());

        boolean collision;
        int currentGridRowIndex = gridRows.size();

        // move piece down until collision is detected (including beyond bottom)
        do {
            collision = detectCollision(--currentGridRowIndex, piece);
        } while (!collision && currentGridRowIndex >= 0);

        // "put" the piece in grid, starting in the previous row prior to the collision
        placePieceInGrid(currentGridRowIndex + 1, piece);
    }

    /**
     * place the piece in the grid, by "combining" the piece data for each row into
     * the grid data for each row starting with the target grid row
     * @param gridRowIndex index of the highest grid row where the piece goes
     * @param piece the piece
     */
    void placePieceInGrid(int gridRowIndex, Piece piece) {
        List<Row> pieceRows = piece.getRows();

        // get grid rows where piece is being placed.
        // subList from (rows below the gridRowIndex based on the number of rows in the piece) to
        // (excluded) row-beyond-the-gridRowIndex
        List<Row> gridRowsSubset = gridRows.subList(gridRowIndex - (pieceRows.size() - 1), gridRowIndex+1);
        Iterator<Row> gridRowIterator = gridRowsSubset.iterator();
        Iterator<Row> pieceRowIterator = pieceRows.iterator();

        while (gridRowIterator.hasNext() && pieceRowIterator.hasNext()) {
            gridRowIterator.next().combineRow(pieceRowIterator.next());
        }
    }

    /**
     * determine if a collision would occur if the piece is placed in this position.
     * "collision" is defined as a square in the piece would be in the same place as
     * an existing square in the grid, or if any square in the piece would be placed
     * below the bottom of the grid
     * @param gridRowIndex the index of the top row of the grid to consider for placement
     * @param piece the piece
     * @return whether a collision would occur
     */
    boolean detectCollision(int gridRowIndex, Piece piece) {
        List<Row> pieceRows = piece.getRows();

        // if any part of the piece would be below the bottom of the grid,
        // return true to indicate that it's not possible to put it here
        if (gridRowIndex < (pieceRows.size() - 1)) {
            return true;
        }

        // get grid rows being considered.
        // subList from (rows below the gridRowIndex based on the number of rows in the piece) to
        // (excluded) row-beyond-the-gridRowIndex
        List<Row> gridRowsSubset = gridRows.subList(gridRowIndex - (pieceRows.size() - 1), gridRowIndex+1);
        Iterator<Row> gridRowIterator = gridRowsSubset.iterator();
        Iterator<Row> pieceRowIterator = pieceRows.iterator();

        while (pieceRowIterator.hasNext() && gridRowIterator.hasNext()) {
            Row gridRow = gridRowIterator.next();
            Row pieceRow = pieceRowIterator.next();
            if (gridRow.isCollision(pieceRow)) {
                return true;
            }
        }

        return false;
    }

    /**
     * debug method to print each row of the grid
     */
    public void printGrid() {
        String dump = "";
        for (Row row : gridRows) {
            dump = row.dump() + dump;
        }
        ConsolePrinter.print(dump);
    }

    /**
     * unit test helper
     */
    List<Row> getGridRows() {
        return gridRows;
    }
}
