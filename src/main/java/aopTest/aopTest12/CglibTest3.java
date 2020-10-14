package aopTest.aopTest12;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibTest3 {

	public static void main(String[] args) {

		HelloBoy helloBoy = new HelloBoy();
		HelloBoy proxyedHelloBoy = (HelloBoy) Enhancer.create(HelloBoy.class, new MethodInterceptor() {

			// 个人猜测
			// object 代理对象
			// method 原方法
			// params 参数数组
			// proxy 代理对象的方法
			@Override
			public Object intercept(Object object, Method method, Object[] params, MethodProxy proxy) throws Throwable {

				boolean hasAnno = method.isAnnotationPresent(Specification.class);

				if (hasAnno) {
					System.out.println("I am pre");
				}

				/**
				 * 猜测，invokeSuper是用来调用原生方法的。但是，原生方法内的方法，估计是通过method.invoke(
				 * object, params)的方式调用，若此时object为代理对象的话，则执行原生方法内的方法的代理方法
				 */
//				类内方法调用其他类内方法时，pre和post都会输出
//				Object result = proxy.invokeSuper(object, params);
//				aopTest.aopTest12.HelloBoy cannot be cast to aopTest.aopTest12.HelloBoy$$EnhancerByCGLIB$$9149ce0c
//				Object result = proxy.invokeSuper(helloBoy, params);

//				为了不递归代理，即类内方法调用其他类内方法时不走代理，正确如下
//				Object result = proxy.invoke(helloBoy, params);
//				或
				Object result = method.invoke(helloBoy, params);

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
