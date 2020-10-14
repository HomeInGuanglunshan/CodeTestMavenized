package jdk18.consumer.p01;

import java.util.function.Consumer;

public class ConsumerTest03 {

	public static void main(String[] args) {
		Consumer<Integer> consumer = (num) -> {
			System.out.println(num);
		};
		Consumer<Integer> consumer2 = (num) -> {
			System.out.println(++num);
		};
		consumer.andThen(consumer2).accept(1);
	}

}
