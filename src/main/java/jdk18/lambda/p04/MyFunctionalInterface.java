package jdk18.lambda.p04;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
@FunctionalInterface
public interface MyFunctionalInterface<T> {

	void method(T s);//自定义函数式接口---注意其定义

	//用一个注解 @FunctionalInterface 去检测这个接口是不是一个函数式接口
}