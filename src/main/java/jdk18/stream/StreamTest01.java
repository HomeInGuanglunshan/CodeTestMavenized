package jdk18.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest01 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list);
		Map<String, String> map = list.stream().map(i -> i * 2)
				.collect(Collectors.toMap(k -> "key" + k, v -> "value" + v));
		System.out.println(map);
		Set<String> set = list.stream().map(Integer::toBinaryString).collect(Collectors.toSet());
		System.out.println(set);
	}

}
