package gravity.pieces;

import gravity.components.Row;

public class ZetaPiece extends Piece {
    public ZetaPiece(int offset) {
        super();
        rows.add(new Row(offset, false, true, true));
        rows.add(new Row(offset, true, true));
    }
}
