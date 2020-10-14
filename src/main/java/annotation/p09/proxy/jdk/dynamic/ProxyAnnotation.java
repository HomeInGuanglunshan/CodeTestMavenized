package annotation.p09.proxy.jdk.dynamic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProxyAnnotation {

	String proxyMode() default "jdkDynamic";

	String before();

	String after();
}
