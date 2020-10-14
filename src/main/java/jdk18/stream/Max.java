package jdk18.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Max {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		Optional<Integer> reduce = numList.stream().max((num1, num2) -> {
			return num1.compareTo(num2);
		});
		System.out.println(reduce.get());
	}

}
