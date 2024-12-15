package gravity.pieces;

import gravity.components.Row;

public class AlphaPiece extends Piece {
    public AlphaPiece(int offset) {
        super();
        rows.add(new Row(offset, true, true, true, true));
    }
}
