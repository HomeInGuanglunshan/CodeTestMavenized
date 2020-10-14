package aopTest.aopTest02;

public class CGProxyTest {
	public static void main(String[] args) {
		Object proxyedObject = new UserServiceImpl(); // 被代理的对象
		CGProxy cgProxy = new CGProxy(proxyedObject);
		UserService proxyObject = (UserService) cgProxy.getProxyObject();
		proxyObject.getUser(1);
		proxyObject.addUser(new User());
	}
}