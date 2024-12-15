package gravity.pieces;

import gravity.components.Row;

public class EtaPiece extends Piece {
    public EtaPiece(int offset) {
        super();
        rows.add(new Row(offset, false, true));
        rows.add(new Row(offset, true, true, true));
    }
}
