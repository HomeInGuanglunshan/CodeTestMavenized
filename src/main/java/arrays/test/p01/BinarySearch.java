package arrays.test.p01;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 3, 6, 5, 1 };
		System.out.println(Arrays.binarySearch(arr, 3));
		System.out.println(Arrays.binarySearch(arr, 5));
		System.out.println(Arrays.binarySearch(arr, 1));
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr, 1));
	}

}
