package practise.practise01;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object proxedObject = new UserServiceImpl();
		ProxyUtil proxyUtil = new ProxyUtil(proxedObject);
		UserService proxyObject = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				UserServiceImpl.class.getInterfaces(), proxyUtil);
		proxyObject.getUser();
		proxyObject.addUser(new User());
	}

}
