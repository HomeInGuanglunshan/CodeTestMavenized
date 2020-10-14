package aopTest.aopTest12;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibTest {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloBoy.class);

		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object object, Method method, Object[] params, MethodProxy proxy) throws Throwable {
				System.out.println("I am pre");
				Object result = proxy.invokeSuper(object, params);
				System.out.println("I am post");
				return result;
			}
		});

		HelloBoy proxyedHelloBoy = (HelloBoy) enhancer.create();
//		proxyedHelloBoy.sayHello();
//		proxyedHelloBoy.sayHi();
		proxyedHelloBoy.sayHelloAndHi();
	}

}
