package bitwise.operation;

public class ShowIntegerAsBinary32Bit {

    public static void main(String[] args) {
        System.out.println(showIntegerAsBinary32Bit(8));
        System.out.println(showIntegerAsBinary32Bit(4));
        System.out.println(showIntegerAsBinary32Bit(2));
        System.out.println(showIntegerAsBinary32Bit(1));
        System.out.println(showIntegerAsBinary32Bit(-1));
        System.out.println(showIntegerAsBinary32Bit(-1 >> 1));
        System.out.println(showIntegerAsBinary32Bit(-1 >> 2));
        System.out.println(showIntegerAsBinary32Bit(-1 >>> 1));
        System.out.println(showIntegerAsBinary32Bit(-1 >>> 2));
    }

    private static final String ZERO32 = "00000000000000000000000000000000";

    public static String showIntegerAsBinary32Bit(int i) {
        return (ZERO32 + Integer.toBinaryString(i)).replaceAll(".*(.{32}$)", "$1").replaceAll("(\\d{4})", "$1 ").trim();
    }

}
