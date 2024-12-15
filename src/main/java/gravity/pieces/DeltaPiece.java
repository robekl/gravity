package gravity.pieces;

import gravity.components.Row;

public class DeltaPiece extends Piece {
    public DeltaPiece(int offset) {
        super();
        rows.add(new Row(offset, true, true));
        rows.add(new Row(offset, true, true));
    }
}
