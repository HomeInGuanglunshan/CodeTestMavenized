package jdk18.function;

import java.util.function.Function;

public class FunctionTest01 {

	public static void main(String[] args) {
		Function<Runnable, Thread> function = task -> new Thread(task);
		function.apply(() -> {
			System.out.println(23333333);
		}).start();
	}

}
