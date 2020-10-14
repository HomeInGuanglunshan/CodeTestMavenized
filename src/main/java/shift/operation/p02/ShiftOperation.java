package shift.operation.p02;

public class ShiftOperation {

	public static void main(String[] args) {

		int a = ~Integer.parseInt("00001101", 2); // -14
//		~00001101 (13)
//		---------
//		 11110010 (-14)
		
		System.out.print(a + " >> " + 1 + " = ");
		System.out.println(a >> 1);
//		11110010 >> 1 = 11111001
//		11111001 -7在计算机中的表示
//		11111000 7的反码
//		00000111 7
		
		System.out.print(a + " >>> " + 1 + " = ");
		System.out.println(a >>> 1);
//		11110010 >>> 1 = 2147483641
//		可化作
//		11111111 11111111 11111111 11110010 >>> 1 = 01111111 11111111 11111111 11111001
	}
}
