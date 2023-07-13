package shift.operation;

public class NegativeRightShift {

    public static void main(String[] args) {

        int decimalNum = -2;
        String binaryNum = ShiftUtils.showIntegerAsBinary32Bit(decimalNum);

        int digit = 1;

        int decimalNumRightShifted = decimalNum >> digit;
        String binaryNumRightShifted = ShiftUtils.showIntegerAsBinary32Bit(decimalNumRightShifted);

        System.out.println(String.format("%s(%s) >> %s = %s(%s)", decimalNum, binaryNum, digit, decimalNumRightShifted,
                binaryNumRightShifted));

    }

}
