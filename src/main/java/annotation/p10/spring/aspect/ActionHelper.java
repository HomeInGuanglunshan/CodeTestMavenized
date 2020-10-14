package annotation.p10.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ActionHelper {

	@Pointcut("execution(* *.eat(..))")
	public void actionPoint() {

	}

	@Before("actionPoint()")
	public void doSthBefore() {
		System.out.println("Only after cooking could I eat");
	}

	@AfterReturning("actionPoint()")
	public void doSthAfter() {
		System.out.println("No one would help you do the dishes but yourself");
	}
}
