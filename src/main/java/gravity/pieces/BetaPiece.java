package gravity.pieces;

import gravity.components.Row;

public class BetaPiece extends Piece {
    public BetaPiece(int offset) {
        super();
        rows.add(new Row(offset, true, true));
        rows.add(new Row(offset, false, true));
        rows.add(new Row(offset, false, true));
    }
}
