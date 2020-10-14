package aopTest.aopTest11_stringBuffer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestClass {

	public static void main(String[] args) {
		final StringBuffer sb = new StringBuffer();
		CommonInterface proxyObject = (CommonInterface) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(), Class4StringBuffer.class.getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						sb.append("\t");
						Object result = method.invoke(new Class4StringBuffer(), args);
						sb.append("\n");
						return result;
					}

				});
		proxyObject.addSth(sb, "I");
		proxyObject.addSth(sb, "love");
		proxyObject.addSth(sb, "you");
		proxyObject.addSth(sb, new Integer(1));
		proxyObject.addSth(sb, true);
		System.out.print(sb.toString());
	}
}
