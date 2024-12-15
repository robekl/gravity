package gravity.components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {
    @Test
    public void emptyRow() {
        Row row = new Row();
        assertTrue(row.isEmpty());
        assertFalse(row.isFull());
    }

    @Test
    public void fullRow() {
        Row row = new Row(0, true, true, true, true, true, true, true, true, true, true);
        assertFalse(row.isEmpty());
        assertTrue(row.isFull());
    }

    @Test
    public void testCombine() {
        Row row1 = new Row(0, true, true);
        Row row2 = new Row(4, true, true);

        int sum = row1.bitCount() + row2.bitCount();

        row2.combineRow(row1);

        assertEquals(sum, row2.bitCount());
    }

    @Test
    public void testCombineToFull() {
        Row row1 = new Row(0, true, true, true, true);
        Row row2 = new Row(4, true, true, true, true, true, true);

        int sum = row1.bitCount() + row2.bitCount();
        assertEquals(10, sum);

        row2.combineRow(row1);

        assertTrue(row2.isFull());
    }

    @Test
    public void testCollision() {
        Row row1 = new Row(0, true, true);
        Row row2 = new Row(1, true);
        Row row3 = new Row(0, false, true);

        assertTrue(row1.isCollision(row2));
        assertTrue(row1.isCollision(row2));
        assertTrue(row2.isCollision(row3));
    }

    @Test
    public void testNoCollision() {
        Row row1 = new Row(0, true, true);
        Row row2 = new Row(2, true, true);

        assertFalse(row1.isCollision(row2));
    }
}