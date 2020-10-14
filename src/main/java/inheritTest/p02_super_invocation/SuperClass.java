package inheritTest.p02_super_invocation;

public class SuperClass {
	public void printA() {
		System.out.println("SuperClass-printA");
		printB();
	}

	public void printB() {
		System.out.println("SuperClass-printB");
	}
}
