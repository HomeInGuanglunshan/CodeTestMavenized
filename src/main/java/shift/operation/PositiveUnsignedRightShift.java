package shift.operation;

public class PositiveUnsignedRightShift {

    public static void main(String[] args) {

        int decimalNum = 13;
        String binaryNum = ShiftUtils.showIntegerAsBinary32Bit(decimalNum);

        int digit = 1;

        int decimalNumUnsignedRightShifted = decimalNum >>> digit;
        String binaryNumUnsignedRightShifted = ShiftUtils.showIntegerAsBinary32Bit(decimalNumUnsignedRightShifted);

        System.out.println(String.format("%s(%s) >>> %s = %s(%s)", decimalNum, binaryNum, digit,
                decimalNumUnsignedRightShifted, binaryNumUnsignedRightShifted));

    }

}
