package jdk18.stream.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Summarizing {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(numList.stream().collect(Collectors.summarizingInt(num -> num)));
		System.out.println(numList.stream().collect(Collectors.summarizingLong(num -> num)));
		System.out.println(numList.stream().collect(Collectors.summarizingDouble(num -> num)));
	}

}
