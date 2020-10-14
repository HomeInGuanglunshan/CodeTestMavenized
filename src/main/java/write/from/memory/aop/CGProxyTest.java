package write.from.memory.aop;

public class CGProxyTest {

	public static void main(String[] args) {
		Object proxyedObject = new UserServiceImpl();
		CGProxy cgProxy = new CGProxy(proxyedObject);
		UserService proxyObject = (UserService) cgProxy.getProxyObject();
		proxyObject.getUser();
		proxyObject.setUser(new User());
	}

}
