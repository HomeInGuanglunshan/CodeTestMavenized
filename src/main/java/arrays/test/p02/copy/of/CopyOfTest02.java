package arrays.test.p02.copy.of;

import java.util.Arrays;

public class CopyOfTest02 {

	public static void main(String[] args) {
		String[] strArr = new String[] { "a", "b", "c", "d", "e" };
		System.out.println(Arrays.toString(Arrays.copyOf(strArr, 100)));

		int[] intArr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(Arrays.copyOf(intArr, 100)));
	}

}
