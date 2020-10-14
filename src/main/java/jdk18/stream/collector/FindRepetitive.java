package jdk18.stream.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/weixin_44420955/article/details/101219643
 */
public class FindRepetitive {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(new Integer[] { 0, 1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 9 });
		Map<Integer, Long> map = numList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((k, v) -> {
			if (v > 1) {
				System.out.println(k + ": " + v);
			}
//			System.out.println(k + ": " + v);
		});
	}

}
