package inheritTest.p02_super_invocation;

public class ChildClass extends SuperClass {
	public void printA() {
		System.out.println("ChildClass-printA");
		super.printA();
	}

	public void printB() {
		System.out.println("ChildClass-printB");
	}

	public static void main(String[] args) {
		ChildClass childClass = new ChildClass();
		childClass.printA();
	}
}