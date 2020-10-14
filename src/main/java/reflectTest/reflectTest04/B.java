package reflectTest.reflectTest04;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class B extends A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		Type type = b.getClass().getGenericSuperclass();
		System.out.println(type instanceof ParameterizedType);
	}

}
