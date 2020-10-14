package write.from.memory.aop;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		Object proxyedObject = new UserServiceImpl();
		ProxyUtil proxyUtil = new ProxyUtil(proxyedObject);
		UserService proxy = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				UserServiceImpl.class.getInterfaces(), proxyUtil);
		proxy.setUser(new User());
		proxy.getUser();
	}

}
