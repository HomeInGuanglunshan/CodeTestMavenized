package write.from.memory.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGProxy implements MethodInterceptor {

	Object target;
	
	public CGProxy(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		System.out.println("do sth before");
		Object result = proxy.invokeSuper(arg0, arg2);
		System.out.println("do sth after");
		return result;
	}

	public Object getProxyObject() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
}
