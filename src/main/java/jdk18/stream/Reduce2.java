package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class Reduce2 {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(numList.stream().reduce(66, (num1, num2) -> num1 > num2 ? num1 : num2));
		System.out.println(numList.stream().reduce(-1, (num1, num2) -> num1 > num2 ? num1 : num2));
	}

}
