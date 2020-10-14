package jdk18.lambda.p10;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test {

	public static void main(String[] args) {
		// Cannot make a static reference to the non-static method nextInt() from the type Random
//		Supplier<Integer> randomInt = Random::nextInt; 
		Supplier<Random> randomConstructor = Random::new;
		System.out.println("Random Int:\t" + randomConstructor.get().nextInt());

		Supplier<Double> randomDouble = new Random()::nextDouble;
		System.out.println("Random double:\t" + randomDouble.get());

		// The type Math does not define ceil() that is applicable here
//		Supplier<Double> doubleCeil = Math::ceil;
		// 供应者能供应函数结果，不能消费参数；消费者能消费参数，不能供应函数结果？
		Consumer<Double> doubleCeil = Math::ceil;
		doubleCeil.andThen(d -> System.out.println("Double ceil:\t" + d)).accept(randomDouble.get());
	}

}
