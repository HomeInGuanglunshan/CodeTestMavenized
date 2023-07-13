package shift.operation;

public class NegativeUnsignedRightShift {

    public static void main(String[] args) {

        int decimalNum = -2;
        String binaryNum = ShiftUtils.showIntegerAsBinary32Bit(decimalNum);

        int digit = 1;

        int decimalNumUnsignedRightShifted = decimalNum >>> digit;
        String binaryNumUnsignedRightShifted = ShiftUtils.showIntegerAsBinary32Bit(decimalNumUnsignedRightShifted);

        System.out.println(String.format("%s(%s) >>> %s = %s(%s)", decimalNum, binaryNum, digit,
                decimalNumUnsignedRightShifted, binaryNumUnsignedRightShifted));

    }

}
