
public class Sequence {

    private static int i;
    private static long result;
    private static long runningResult;
    private static int callsToRecursive;
    protected static int efficiency;
    private static int totalEfficiency;

    public static long computeIterative(int x) {
        long secPrevious = 0, previous = 1, current = 0;

        if (x == 0) {
            current = 0;
            GetEfficiency(true);

        } else if (x == 1) {
            current = 1;
            GetEfficiency(true);

        } else {
            for (i = 0; i < x - 1; i++) {
                current = 2 * previous + secPrevious;
                secPrevious = previous;
                previous = current;
                GetEfficiency(true);

            }
        }
        return current;
    }

    public static long computeRecursive(int c) {
        GetEfficiency(true);
        if (c == 0 || c == 1) {
            result = c;
        } else {
            result = 2 * computeRecursive(c - 1) + computeRecursive(c - 2);
        }

        return result;
    }

    public static int GetEfficiency(boolean check) {
        if (check == true) {
            efficiency++;
        }
        return efficiency;

    }

}
