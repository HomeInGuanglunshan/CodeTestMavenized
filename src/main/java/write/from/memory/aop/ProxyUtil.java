package write.from.memory.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyUtil implements InvocationHandler {

	Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("do sth before");
		Object result = method.invoke(target, args);
		System.out.println("do sth after");
		return result;
	}
	
	public ProxyUtil(Object target) {
		super();
		this.target = target;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
