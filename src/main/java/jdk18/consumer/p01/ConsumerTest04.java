package jdk18.consumer.p01;

import java.util.function.Consumer;

public class ConsumerTest04 {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (num) -> {
			System.out.println(num);
		};
		Consumer<Integer> consumer2 = (num) -> {
			System.out.println(++num);
		};
		Consumer<Integer> consumer3 = (num) -> {
			System.out.println(++num);
		};
		Consumer<Integer> consumer4 = (num) -> {
			System.out.println(++num);
		};
		consumer.andThen(consumer2).andThen(consumer3).andThen(consumer4).accept(1);
	}

}
