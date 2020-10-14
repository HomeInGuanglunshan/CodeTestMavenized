package jdk18.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		testFlatMap();
	}

	/**
	 * flatMap .
	 */
	public static void testFlatMap() {
		//创建一个 装有两个泛型为integer的集合
		Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
		// 将两个合为一个
		Stream<Integer> integerStream = stream.flatMap(integers -> integers.stream());
		// 为新的集合
		List<Integer> collect = integerStream.collect(Collectors.toList());
		System.out.println("新stream大小:" + collect.size());
		System.out.println("-----合并后-----");
		collect.forEach(o -> System.out.println(o));
	}
}
