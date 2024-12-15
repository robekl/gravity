package gravity.pieces;

import gravity.components.Row;

public class GammaPiece extends Piece {
    public GammaPiece(int offset) {
        super();
        rows.add(new Row(offset, true, true));
        rows.add(new Row(offset, true));
        rows.add(new Row(offset, true));
    }
}
