package annotation.p07;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加了<code>@Documented</code>这个注解之后，通过javadoc生成的文档中，
 * 使用了@MyDocumentedtAnnotation的方法或类等，会出现@MyDocumentedtAnnotation
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@interface MyDocumentedtAnnotation {

	public String key() default "yu";

	public String value() default "cug";

}