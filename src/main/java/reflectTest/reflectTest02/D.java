package reflectTest.reflectTest02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class D extends A {

	public static void main(String[] args) {
		D d = new D();
		Type type = d.getClass().getGenericSuperclass();
		System.out.println(type instanceof ParameterizedType);
		System.out.println(((ParameterizedType) type).getActualTypeArguments().length);
	}
}
