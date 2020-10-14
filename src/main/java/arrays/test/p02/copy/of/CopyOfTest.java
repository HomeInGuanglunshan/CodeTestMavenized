package arrays.test.p02.copy.of;

import java.util.Arrays;

public class CopyOfTest {

	public static void main(String[] args) {
		String[] strArr = new String[] { "a", "b", "c", "d", "e" };
		Arrays.copyOf(strArr, 100);
		System.out.println(Arrays.toString(strArr));
		for (String str : strArr) {
			System.out.print(str);
			System.out.print(", ");
		}
		System.out.println();

		int[] intArr = new int[] { 1, 2, 3, 4, 5 };
		Arrays.copyOf(intArr, 100);
		System.out.println(Arrays.toString(intArr));
		for (int intNum : intArr) {
			System.out.print(intNum);
			System.out.print(", ");
		}
	}

}
