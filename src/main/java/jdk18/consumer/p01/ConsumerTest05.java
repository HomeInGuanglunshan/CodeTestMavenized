package jdk18.consumer.p01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ConsumerTest05 {

	public static void main(String[] args) {
		Consumer<AtomicInteger> consumer = (num) -> {
			System.out.println(num.addAndGet(1));
		};
		Consumer<AtomicInteger> consumer2 = (num) -> {
			System.out.println(num.addAndGet(1));
		};
		Consumer<AtomicInteger> consumer3 = (num) -> {
			System.out.println(num.addAndGet(1));
		};
		Consumer<AtomicInteger> consumer4 = (num) -> {
			System.out.println(num.addAndGet(1));
		};
		consumer.andThen(consumer2).andThen(consumer3).andThen(consumer4).accept(new AtomicInteger(1));
	}

}
