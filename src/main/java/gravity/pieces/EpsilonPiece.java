package gravity.pieces;

import gravity.components.Row;

public class EpsilonPiece extends Piece {
    public EpsilonPiece(int offset) {
        super();
        rows.add(new Row(offset, true, true));
        rows.add(new Row(offset, false, true, true));
    }
}
