package annotation.p09.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.lang3.StringUtils;

public class ProxyUtil {

	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), clazz.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						Method methodImpl = clazz.getDeclaredMethod(method.getName());
						ProxyAnnotation proxyAnnotation = methodImpl.getDeclaredAnnotation(ProxyAnnotation.class);

						Object instance = clazz.newInstance();

						if (null != proxyAnnotation && StringUtils.isNotBlank(proxyAnnotation.before())) {
							try {
								Method before = clazz.getDeclaredMethod(proxyAnnotation.before());
								before.invoke(instance);
							} catch (NoSuchMethodException e) {
								System.out.println("I don't know what to do before I " + method.getName());
							}
						}

						Object result = method.invoke(instance, args);
						// 以下写法，调用proxy，即是代理对象本身，由此会触发无限递归
						// Object result = method.invoke(proxy, args);

						if (null != proxyAnnotation && StringUtils.isNotBlank(proxyAnnotation.after())) {
							try {
								Method after = clazz.getDeclaredMethod(proxyAnnotation.after());
								after.invoke(instance);
							} catch (NoSuchMethodException e) {
								System.out.println("I don't know what to do after I " + method.getName());
							}
						}

						System.out.println("----------------------------------");

						return result;
					}
				});
	}

}
