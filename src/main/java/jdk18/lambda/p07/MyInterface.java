package jdk18.lambda.p07;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
@FunctionalInterface
public interface MyInterface<T, R> {

	R method(T t);//有参---可以使用Java8中已经存在的Function---具备此特性
}