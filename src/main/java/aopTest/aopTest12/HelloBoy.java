package aopTest.aopTest12;

public class HelloBoy {

	@Specification
	public void sayHello() {
		System.out.println("hello!");
	}

	@Specification
	public void sayHi() {
		System.out.println("hi!");
	}

	public void sayHelloAndHi() {
		sayHello();
		sayHi();
	}
}
