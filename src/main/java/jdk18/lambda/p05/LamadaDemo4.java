package jdk18.lambda.p05;

import java.util.function.Supplier;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
public class LamadaDemo4 {
	public static void main(String[] args) {

		new Supplier<Double>() {
			@Override
			public Double get() {
				return 3.1;
			}
		};

	}
}