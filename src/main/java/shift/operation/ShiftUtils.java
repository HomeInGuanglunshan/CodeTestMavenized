package shift.operation;

public class ShiftUtils {

    private static final String ZERO32 = "00000000000000000000000000000000";

    public static String showIntegerAsBinary32Bit(int i) {
        return (ZERO32 + Integer.toBinaryString(i)).replaceAll(".*(.{32}$)", "$1").replaceAll("(\\d{4})", "$1 ").trim();
    }

}
