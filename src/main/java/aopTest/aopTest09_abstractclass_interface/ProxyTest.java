package aopTest.aopTest09_abstractclass_interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		A proxyObject = (A) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				C.class.getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("LADIES AND GENTLEMEN");
						Object result = method.invoke(new C(), args);
						System.out.println("LET'S HAVE A GOODTIME");
						return result;
					}
				});
		proxyObject.sayHello();
	}

}
