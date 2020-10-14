package cglib.proxy.test.p01;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyTest {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Worker.class);
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
				System.out.println("put on uniform");
				Object result = proxy.invokeSuper(arg0, arg2);
				System.out.println("take off uniform");
				return result;
			}

		});
		Worker worker = (Worker) enhancer.create();
		worker.work();
	}

}
