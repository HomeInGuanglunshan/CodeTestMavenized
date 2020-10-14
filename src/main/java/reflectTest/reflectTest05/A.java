package reflectTest.reflectTest05;

public class A {

	public A() {
		System.out.println(getClass());
		System.out.println(getClass().getGenericSuperclass());
	}
}
