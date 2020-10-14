package jdk18.lambda.p04;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
public class LamadaDemo3 {
	public static void main(String[] args) {

		//首先自定义一个函数式接口：MyFunctionalInterface
		new MyFunctionalInterface<String>() {
			@Override
			public void method(String s) {

			}
		}.method("你好吗？");

		//Lamada表达式的用法

		MyFunctionalInterface<String> lamada = (s) -> System.out.println(s);

	}
}