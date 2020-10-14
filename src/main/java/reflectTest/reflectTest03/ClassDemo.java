package reflectTest.reflectTest03;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class param<T1, T2> {

	class A {
	}

	class B extends A {
	}

	public param() {

		B t = new B();
		
		Type type = t.getClass().getGenericSuperclass();

		System.out.println("B is A's super class :" + ((ParameterizedType) type).getActualTypeArguments().length);
	
		System.out.println(type);
		
		System.out.println(type instanceof ParameterizedType);
	}

}

public class ClassDemo extends param<MyClass, MyInvoke> {
	public static void main(String[] args) {
		ClassDemo classDemo = new ClassDemo();
	}
}
