package extendTest.extendTest02;

public class C {

	public void yell() {
		System.out.println("C");
	}
	
	public static void main(String[] args) {
		C c = new A();
		c.yell();
	}
}
