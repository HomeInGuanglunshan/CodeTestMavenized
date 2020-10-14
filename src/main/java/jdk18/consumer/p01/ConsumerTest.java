package jdk18.consumer.p01;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<Integer> consumer = x -> {
			int a = x + 2;
			System.out.println(a);// 12
			System.out.println(a + "_");// 12_
		};
		consumer.accept(10);
	}

}
