package jdk18.stream;

import java.util.stream.Stream;

public class FlatMap2 {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

//		stream.flatMap(num -> Stream.of(num * 2));
		// stream has already been operated upon or closed
//		stream.forEach(num -> System.out.println(num));

		stream.flatMap(num -> Stream.of(num * 2)).forEach(num -> System.out.println(num));
	}

}
