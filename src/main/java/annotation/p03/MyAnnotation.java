package annotation.p03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * url https://www.cnblogs.com/xdp-gacl/p/3622275.html
 */
@Retention(RetentionPolicy.RUNTIME)
// Retention注解决定MyAnnotation注解的生命周期
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface MyAnnotation {
	/**
	 * 定义基本属性
	 * 
	 * @return
	 */
	String color();
}