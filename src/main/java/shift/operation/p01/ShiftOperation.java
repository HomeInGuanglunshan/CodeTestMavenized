package shift.operation.p01;

public class ShiftOperation {

	public static void main(String[] args) {

		// 00001101 (13)
		System.out.print(Integer.parseInt("00001101", 2) + " >> " + 1 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) >> 1);

		System.out.print(Integer.parseInt("00001101", 2) + " >> " + 2 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) >> 2);

		System.out.print(Integer.parseInt("00001101", 2) + " >> " + 3 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) >> 3);

		System.out.print(Integer.parseInt("00001101", 2) + " >> " + 4 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) >> 4);

		System.out.print(Integer.parseInt("00001101", 2) + " << " + 1 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) << 1);

		System.out.print(Integer.parseInt("00001101", 2) + " << " + 2 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) << 2);

		System.out.print(Integer.parseInt("00001101", 2) + " << " + 3 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) << 3);

		System.out.print(Integer.parseInt("00001101", 2) + " << " + 4 + " = ");
		System.out.println(Integer.parseInt("00001101", 2) << 4);

	}
}
