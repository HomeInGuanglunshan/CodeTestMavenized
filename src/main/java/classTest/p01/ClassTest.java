package classTest.p01;

public class ClassTest {

	public static void main(String[] args) {
//		Class<?> clazz = Integer.class.getDeclaringClass();
//		Integer original = new Integer(342);
//		Object changedObject = original;
//		System.out.println(changedObject);
//		System.out.println(restore(changedObject, clazz));
		
		A a = new B();
		a.sayA();
		B b = restore(a, B.class);
		b.sayB();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T restore(Object changedObj, Class<T> clazz) {
		return (T) changedObj;
	}
}

class A {
	
	public static void sayA() {
		System.out.println("I am A");
	}
	
}

class B extends A {
	
	public static void sayB() {
		System.out.println("I am B");
	}
	
}
