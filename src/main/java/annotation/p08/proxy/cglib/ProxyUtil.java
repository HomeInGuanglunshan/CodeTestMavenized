package annotation.p08.proxy.cglib;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyUtil {

	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object object, Method method, Object[] objectArr, MethodProxy methodProxy)
					throws Throwable {
				Proxy proxyAnno = method.getDeclaredAnnotation(Proxy.class);
				Object instance = clazz.newInstance();

				if (null != proxyAnno && StringUtils.isNotBlank(proxyAnno.before())) {
					try {
						Method before = clazz.getDeclaredMethod(proxyAnno.before());
						before.invoke(instance);
						// 此object是个proxy，如果在此处被invoke了，会递归触发代理操作
						// before.invoke(object);
					} catch (NoSuchMethodException e) {
						System.out.println("I don't know what to do before I " + method.getName());
					}
				}

				Object result = methodProxy.invokeSuper(object, objectArr);

				if (null != proxyAnno && StringUtils.isNotBlank(proxyAnno.after())) {
					try {
						Method after = clazz.getDeclaredMethod(proxyAnno.after());
						after.invoke(instance);
					} catch (NoSuchMethodException e) {
						System.out.println("I don't know what to do after I " + method.getName());
					}
				}

				System.out.println("----------------------------------");

				return result;
			}
		});
		return (T) enhancer.create();
	}
}
