package annotation.p03;

/**
 * url https://www.cnblogs.com/xdp-gacl/p/3622275.html
 */
@MyAnnotation(color = "red") // 应用MyAnnotation注解的color属性
public class MyAnnotationTest {
	public static void main(String[] args) {
		/**
		 * 用反射方式获得注解对应的实例对象后，在通过该对象调用属性对应的方法
		 */
		MyAnnotation annotation = (MyAnnotation) MyAnnotationTest.class.getAnnotation(MyAnnotation.class);
		System.out.println(annotation.color());// 输出red
	}
}