package gravity.engine;

import gravity.components.Grid;
import gravity.pieces.*;

import java.util.Arrays;
import java.util.Scanner;

public class Engine {
    public void execute(String[] args) {
        if (args.length != 0) {
            ConsolePrinter.enableDebug();
        }

        final Scanner scanner = new Scanner(System.in);

        // read line
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            int height = processInputLine(line.trim());

            // print grid height
            System.out.println(height);
        }
    }

    public static int processInputLine(String line) {
        // new grid for each line
        Grid grid = new Grid();

        ConsolePrinter.print(line + ": ");

        // process each piece. Each line of the input file is a comma-separated list of piece data
        Arrays.asList(line.split(","))
                .forEach(pieceAndOffset -> processPiece(pieceAndOffset.trim(), grid));

        return grid.getHeight();
    }

    public static void processPiece(String pieceAndOffset, Grid grid) {
        // determine offset and piece type based on input data format:
        // first character is shape indicator, second character is the left-most
        // column of the grid that the shape occupies, starting from zero

        int offset = pieceAndOffset.charAt(pieceAndOffset.length()-1) - '0';
        Piece piece = switch (pieceAndOffset.substring(0, pieceAndOffset.length()-1)) {
            case "Alpha": yield new AlphaPiece(offset);
            case "Beta": yield new BetaPiece(offset);
            case "Gamma": yield new GammaPiece(offset);
            case "Delta": yield new DeltaPiece(offset);
            case "Epsilon": yield new EpsilonPiece(offset);
            case "Zeta": yield new ZetaPiece(offset);
            case "Eta": yield new EtaPiece(offset);
            default:
                throw new IllegalStateException("Unexpected value: " + pieceAndOffset.charAt(0));
        };

        grid.addPieceToGrid(piece);

        grid.removeEmptyRows();
        grid.removeFullRows();

        ConsolePrinter.println("\nAfter " + pieceAndOffset);
        grid.printGrid();
    }
}
