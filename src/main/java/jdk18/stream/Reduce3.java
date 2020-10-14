package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class Reduce3 {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(numList.stream().reduce(0, (num1, num2) -> num1 + num2, (num1, num2) -> num1 + num2));
	}

}
