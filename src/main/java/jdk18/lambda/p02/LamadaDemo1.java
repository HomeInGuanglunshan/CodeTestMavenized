package jdk18.lambda.p02;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
public class LamadaDemo1 {
	public static void main(String[] args) {
		//常见的函数式接口：Runnable、 Comparable--排序(是一个函数式接口吗？)

		Comparable<Integer> comparable = new Comparable<Integer>() {
			@Override
			public int compareTo(Integer o) {
				return 0;
			}
		};

		//Lambada表达式的方法

		Comparable<Integer> com = (a) -> a;
		int i = com.compareTo(3);
		System.out.println(i);
	}
}