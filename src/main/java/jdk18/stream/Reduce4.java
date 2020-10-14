package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class Reduce4 {

	public static void main(String[] args) {
		List<String> numList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		System.out.println(numList.stream().reduce("", (num1, num2) -> num1 + num2, (num1, num2) -> num1 + num2));
		System.out.println(
				numList.stream().reduce("987654321", (num1, num2) -> num1 + num2, (num1, num2) -> num1 + num2));
		System.out.println(numList.stream().reduce("123456789", (num1, num2) -> num1 + num2));
		System.out.println(numList.stream().reduce((num1, num2) -> num1 + num2).get());
	}

}
