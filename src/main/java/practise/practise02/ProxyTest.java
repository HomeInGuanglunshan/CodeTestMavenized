package practise.practise02;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Object proxyedObject = new UserServiceImpl();
		ProxyUtil proxyUtil = new ProxyUtil(proxyedObject);
		UserService proxyObject = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				UserServiceImpl.class.getInterfaces(), proxyUtil);
		proxyObject.getUser();
		proxyObject.setUser();
	}

}
