package aopTest.aopTest01;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Object proxyedObject = new UserServiceImpl(); // 被代理的对象
		ProxyUtil proxyUtils = new ProxyUtil(proxyedObject);
		// 生成代理对象，对被代理对象的这些接口进行代理：UserServiceImpl.class.getInterfaces()
		UserService proxyObject = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				UserServiceImpl.class.getInterfaces(), proxyUtils);
		proxyObject.getUser(1);
		proxyObject.addUser(new User());
	}
}