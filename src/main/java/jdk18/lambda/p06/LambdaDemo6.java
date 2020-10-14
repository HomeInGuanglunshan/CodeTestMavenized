package jdk18.lambda.p06;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
public class LambdaDemo6 {
	public static void main(String[] args) {
		// 方法引用 :: 是Lambda表达式的另一种简写方式
		//类名::静态方法
		//对象::实例方法
		//类名::实例方法
		Supplier<Double> supplier = new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		};

		Supplier<Double> supplier2 = () -> Math.random();//方法引用

		Supplier<Double> supplier3 = Math::random;

		System.out.println("-------------------------------------");
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				PrintStream out = System.out;
				out.println(s);
			}
		};
		PrintStream out = System.out;
		Consumer<String> consumer2 = (s) -> out.println(s);
		Consumer<String> consumer3 = out::println;//方法引用也没有参数
		consumer3.accept("bbbb");
		System.out.println("------------------------------");
		Comparator<String> stringComparator = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				//你对一个函数式接口中的抽象方法重写时，如果说你传的这两个参数
				//一个参数作为了调用者，一个参数作为了 传入者
				//那么你也可以使用方法引用来简写Lambda表达式
				return s1.compareTo(s2);
			}
		};
		Comparator<String> stringComparator2 = (s1, s2) -> s1.compareTo(s2);

		Comparator<String> stringComparator3 = String::compareTo;

		System.out.println("------------------------------------------------");
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		};

		Comparator<Integer> comparator2 = (x, y) -> x.compareTo(y);
		Comparator<Integer> comparator3 = Integer::compareTo;
	}
}
