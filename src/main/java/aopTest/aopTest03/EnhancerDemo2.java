package aopTest.aopTest03;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class EnhancerDemo2 implements MethodInterceptor {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		// enhancer.setSuperclass(EnhancerDemo2.class);
		// 貌似上行代码行不通,SuperClass和CallBack的类必须是两个不同的类?
		enhancer.setSuperclass(EnhancerDemo.class);
		enhancer.setCallback(new EnhancerDemo2());

		EnhancerDemo demo = (EnhancerDemo) enhancer.create();
		demo.test();
		System.out.println(demo); // 如果intercept方法返回null,这里也会输出null
	}

	public void test() {
		System.out.println("EnhancerDemo test()");
	}

	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
		System.out.println("before invoke " + method);
		// proxy.invokeSuper(arg0, arg2);
		Object obj = proxy.invokeSuper(arg0, arg2);
		System.out.println("after invoke " + method);
		// return null;
		return obj;
	}

}