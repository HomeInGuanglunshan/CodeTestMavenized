package bitwise.operation.p01;

public class BitwiseOperation {

	public static void main(String[] args) {

		System.out.print(Integer.parseInt("00111100", 2) + " & " + Integer.parseInt("00001101", 2) + " = ");
		System.out.println(Integer.parseInt("00111100", 2) & Integer.parseInt("00001101", 2));
//		 00111100 (60)
//		&00001101 (13)
//		---------
//		 00001100 (12)
		System.out.println("-------------");

		System.out.print(Integer.parseInt("00111100", 2) + " | " + Integer.parseInt("00001101", 2) + " = ");
		System.out.println(Integer.parseInt("00111100", 2) | Integer.parseInt("00001101", 2));
//		 00111100 (60)
//		|00001101 (13)
//		---------
//		 00111101 (61)
		System.out.println("-------------");

		System.out.print(Integer.parseInt("00111100", 2) + " ^ " + Integer.parseInt("00001101", 2) + " = ");
		System.out.println(Integer.parseInt("00111100", 2) ^ Integer.parseInt("00001101", 2));
//		 00111100 (60)
//		^00001101 (13)
//		---------
//		 00110001 (49)
		System.out.println("-------------");

//		~00111100 (60)
//		---------
//		 11000011 (-61)
		System.out.print("~" + Integer.parseInt("00111100", 2) + " = ");
		System.out.println(~Integer.parseInt("00111100", 2));

	}

}
