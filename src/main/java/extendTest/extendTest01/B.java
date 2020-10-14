package extendTest.extendTest01;

public class B extends A {
	
	public void method() {
		System.out.println("I am B");
	}
	
	public void testMethod() {
		super.method();
	}
	
	public static void main(String[] args) {
		new B().testMethod();
		System.out.println((new B()) instanceof A);
		System.out.println((new B()) instanceof B);
		System.out.println((new A()) instanceof A);
		System.out.println((new A()) instanceof B);
		A a = new B();
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
//		B b = (B) (new A());
//		System.out.println(b instanceof A);
//		System.out.println(b instanceof B);
	}
	
}
