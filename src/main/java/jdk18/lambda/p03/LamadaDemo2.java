package jdk18.lambda.p03;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
public class LamadaDemo2 {
	public static void main(String[] args) {

		//TreeSet排序新高度---Comparator本身有泛型
		TreeSet<Integer> tereeSet = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {

				return a + b;
			}
		});

		//Lambada表达式的形式

		new TreeSet<Integer>((a, b) -> a - b);
	}
}