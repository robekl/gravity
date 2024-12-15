package gravity.engine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EngineTest {
    @Test
    public void testExample1() {
        String inputLine = "Alpha0,Alpha4,Delta8";
        int result = Engine.processInputLine(inputLine);
        assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        String inputLine = "Eta1,Zeta3,Alpha4";
        int result = Engine.processInputLine(inputLine);
        assertEquals(4, result);
    }

    @Test
    public void testExample3() {
        String inputLine = "Delta0,Alpha2,Alpha6,Alpha0,Alpha6,Alpha6,Delta2,Delta4";
        int result = Engine.processInputLine(inputLine);
        assertEquals(3, result);
    }

    @Test
    public void testPieceAlpha() {
        String inputLine = "Alpha0";
        int result = Engine.processInputLine(inputLine);
        assertEquals(1, result);
    }

    @Test
    public void testPieceAlphaAlphaAlphaAlphaDelta() {
        String inputLine = "Alpha0,Alpha0,Alpha4,Alpha4,Delta8";
        int result = Engine.processInputLine(inputLine);
        assertEquals(0, result);
    }

    @Test
    public void testPieceGamma() {
        String inputLine = "Gamma8";
        int result = Engine.processInputLine(inputLine);
        assertEquals(3, result);
    }

    @Test
    public void testPieceBeta() {
        String inputLine = "Beta0";
        int result = Engine.processInputLine(inputLine);
        assertEquals(3, result);
    }

    @Test
    public void testPieceDelta() {
        String inputLine = "Delta2";
        int result = Engine.processInputLine(inputLine);
        assertEquals(2, result);
    }

    @Test
    public void testPieceEpsilon() {
        String inputLine = "Epsilon2";
        int result = Engine.processInputLine(inputLine);
        assertEquals(2, result);
    }

    @Test
    public void testPieceEta() {
        String inputLine = "Eta2";
        int result = Engine.processInputLine(inputLine);
        assertEquals(2, result);
    }

    @Test
    public void testPieceZeta() {
        String inputLine = "Zeta2";
        int result = Engine.processInputLine(inputLine);
        assertEquals(2, result);
    }

    @Test
    public void testPieceAlphaAlphaEpsilon() {
        String inputLine = "Alpha0,Alpha6,Epsilon4";
        int result = Engine.processInputLine(inputLine);
        assertEquals(1, result);
    }

    @Test
    public void testPieceAlphaAlphaZeta3() {
        String inputLine = "Alpha0,Alpha6,Zeta3";
        int result = Engine.processInputLine(inputLine);
        assertEquals(1, result);
    }

    @Test
    public void testPieceAlphaAlphaZeta0() {
        String inputLine = "Alpha0,Alpha6,Zeta0";
        int result = Engine.processInputLine(inputLine);
        assertEquals(3, result);
    }

    @Test
    public void testTestTest() {
        String inputLine = "Delta0,Alpha2,Alpha6,Alpha0,Alpha6,Alpha6,Delta2,Delta4";
        int result = Engine.processInputLine(inputLine);
        assertEquals(3, result);
    }

    @Test
    public void testBigInput() {
        List<String> pieces = new ArrayList<>(700);
        addManyPieces(pieces, "Alpha", 6);
        addManyPieces(pieces, "Gamma", 8);
        addManyPieces(pieces, "Beta", 8);
        addManyPieces(pieces, "Delta", 8);
        addManyPieces(pieces, "Epsilon", 7);
        addManyPieces(pieces, "Eta", 7);
        addManyPieces(pieces, "Zeta", 7);
        Collections.shuffle(pieces);
        int result = Engine.processInputLine(String.join(",", pieces));
        System.out.println(result + " rows");
    }

    private void addManyPieces(List<String> pieces, String shape, int maxOffset) {
        Random random = new Random();
        for(int i=100;i>0;i--) {
            pieces.add(shape + random.nextInt(maxOffset + 1));
        }
    }
}