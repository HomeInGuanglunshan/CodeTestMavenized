package shift.operation;

public class NegativeLeftShift {

    public static void main(String[] args) {

        int decimalNum = -2;
        String binaryNum = ShiftUtils.showIntegerAsBinary32Bit(decimalNum);

        int digit = 1;

        int decimalNumLeftShifted = decimalNum << digit;
        String binaryNumLeftShifted = ShiftUtils.showIntegerAsBinary32Bit(decimalNumLeftShifted);

        System.out.println(String.format("%s(%s) << %s = %s(%s)", decimalNum, binaryNum, digit, decimalNumLeftShifted,
                binaryNumLeftShifted));

    }

}
