package jdk18.stream.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Averaging {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(numList.stream().collect(Collectors.averagingInt(num -> num)));
		System.out.println(numList.stream().collect(Collectors.averagingLong(num -> num)));
		System.out.println(numList.stream().collect(Collectors.averagingDouble(num -> num)));
	}

}
