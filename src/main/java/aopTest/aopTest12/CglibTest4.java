package aopTest.aopTest12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibTest4 {

	public static void main(String[] args) {

		HelloGirl helloGirl = new HelloGirl();
		HelloGirl proxyedHelloGirl = (HelloGirl) Enhancer.create(HelloGirl.class, new MethodInterceptor() {

			@Override
			public Object intercept(Object object, Method method, Object[] params, MethodProxy proxy) throws Throwable {

				boolean hasAnno = method.isAnnotationPresent(Asynchronous.class);

				if (hasAnno) {

					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								method.invoke(helloGirl, params);
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();

					return null;
				} else {
					return method.invoke(helloGirl, params);
				}
			}
		});

		proxyedHelloGirl.sayHelloTenTimes();
		proxyedHelloGirl.sayHiTenTimes();
		proxyedHelloGirl.sayGoodbye();
	}

}
