package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class Distinct {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9 });
		numList.stream().distinct().forEach(num -> System.out.println(num));
	}

}
