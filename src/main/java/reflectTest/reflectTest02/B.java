package reflectTest.reflectTest02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class B extends A<C> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		Type type = b.getClass().getGenericSuperclass();
		System.out.println(type instanceof ParameterizedType);
	}

}
