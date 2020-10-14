package write.from.memory.aop02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Animal proxyedDog = (Animal) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				dog.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("I am ready to yell");
						method.invoke(dog, args);
						System.out.println("I have yelled");
						return null;
					}
				});
		proxyedDog.yell();
	}
}
