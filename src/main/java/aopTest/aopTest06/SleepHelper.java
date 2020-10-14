package aopTest.aopTest06;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 通过注解的方式 添加增强
 */
@Aspect
@Component
public class SleepHelper {

	/* @Pointcut("execution(* com.tgb.springaop.service.impl..*(..))") */
	@Pointcut("execution(* *.sleep(..))")
	public void sleeppoint() {
	}

	@Before("sleeppoint()")
	public void beforeSleep() {
		System.out.println("睡觉前要敷面膜");
	}

	@AfterReturning("sleeppoint()")
	public void afterSleep() {
		System.out.println("睡觉后要做美梦");
	}
}