package write.from.memory.aop02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyTest {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Dog.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy)
					throws Throwable {
				System.out.println("I am ready to yell");
				methodProxy.invokeSuper(object, objects);
				System.out.println("I have yelled");
				return null;
			}
		});
		Dog proxyedDog = (Dog) enhancer.create();
		proxyedDog.yell();
	}
}
