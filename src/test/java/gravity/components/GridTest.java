package gravity.components;

import gravity.pieces.AlphaPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    public void testRemoveEmptyRow() {
        Grid grid = new Grid();
        grid.addEmptyRow();
        assertEquals(1, grid.getHeight());
        grid.removeEmptyRows();
        assertEquals(0, grid.getHeight());
    }

    @Test
    public void testDontRemoveEmptyRow() {
        Grid grid = new Grid();
        grid.getGridRows().add(new Row(0, true));
        assertEquals(1, grid.getHeight());
        grid.removeEmptyRows();
        assertEquals(1, grid.getHeight());
    }

    @Test
    public void testRemoveFullRow() {
        Grid grid = new Grid();
        grid.getGridRows().add(new Row(0, true, true, true, true, true, true, true, true, true, true));
        assertEquals(1, grid.getHeight());
        grid.removeFullRows();
        assertEquals(0, grid.getHeight());
    }

    @Test
    public void testDontRemoveFullRow() {
        Grid grid = new Grid();
        grid.getGridRows().add(new Row(0, true));
        assertEquals(1, grid.getHeight());
        grid.removeFullRows();
        assertEquals(1, grid.getHeight());
    }

    @Test
    public void testAddOneIPiece() {
        Grid grid = new Grid();
        grid.addPieceToGrid(new AlphaPiece(0));
        assertEquals(1, grid.getHeight());
        assertEquals(4, grid.getGridRows().get(0).bitCount());
    }

    @Test
    public void testAddTwoIPieces() {
        Grid grid = new Grid();
        grid.addPieceToGrid(new AlphaPiece(0));
        grid.addPieceToGrid(new AlphaPiece(0));
        grid.removeEmptyRows();
        assertEquals(2, grid.getHeight());
        assertEquals(8, grid.getGridRows().stream().map(Row::bitCount).reduce(0, Integer::sum));
    }

    @Test
    public void testAddTwoIPiecesSideBySide() {
        Grid grid = new Grid();
        grid.addPieceToGrid(new AlphaPiece(0));
        grid.addPieceToGrid(new AlphaPiece(4));
        grid.removeEmptyRows();
        assertEquals(1, grid.getHeight());
        assertEquals(8, grid.getGridRows().stream().map(Row::bitCount).reduce(0, Integer::sum));
    }
}