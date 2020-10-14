package reflectTest.reflectTest02;

public class A<T> {

	public A() {
		System.out.println(getClass());
		Object genericClz = getClass().getGenericSuperclass();
		System.out.println(genericClz);
	}

}
