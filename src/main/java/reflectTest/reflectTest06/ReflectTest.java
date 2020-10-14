package reflectTest.reflectTest06;

import java.lang.reflect.Field;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		Complex complex = new Complex();
		Field field = complex.getClass().getDeclaredField("id");
		field.setAccessible(true);
		System.out.println(field.getType().getTypeName());

		field = complex.getClass().getDeclaredField("number");
		field.setAccessible(true);
		System.out.println(field.getType().getTypeName());
	}
}
