package gravity.engine;

/**
 * helper for console debugging.
 */
public class ConsolePrinter {
    static private boolean debug = false;

    public static void enableDebug() {
        debug = true;
    }

    public static void print(String s) {
        if (debug) {
            System.out.print(s);
        }
    }

    public static void println(String s) {
        print(s + "\n");
    }
}
