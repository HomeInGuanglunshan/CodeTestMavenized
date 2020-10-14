package aopTest.aopTest05;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 定义一个睡眠的增强 同时实现前置 和后置
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("睡觉前小个便");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("睡觉后肯定会做梦");
	}

}