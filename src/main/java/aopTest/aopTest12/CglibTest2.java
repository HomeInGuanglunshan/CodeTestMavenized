package aopTest.aopTest12;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibTest2 {

	public static void main(String[] args) {

		HelloBoy proxyedHelloBoy = (HelloBoy) Enhancer.create(HelloBoy.class, new MethodInterceptor() {
			@Override
			public Object intercept(Object object, Method method, Object[] params, MethodProxy proxy) throws Throwable {
				boolean hasAnno = method.isAnnotationPresent(Specification.class);
				if (hasAnno) {
					System.out.println("I am pre");
				}
				Object result = proxy.invokeSuper(object, params);
				if (hasAnno) {
					System.out.println("I am post");
				}
				return result;
			}
		});

		proxyedHelloBoy.sayHello();
		System.out.println("---------------------------");
		proxyedHelloBoy.sayHi();
		System.out.println("---------------------------");
		proxyedHelloBoy.sayHelloAndHi();
	}

}
