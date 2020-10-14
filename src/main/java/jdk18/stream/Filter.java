package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		numList.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.println(num));
	}

}
