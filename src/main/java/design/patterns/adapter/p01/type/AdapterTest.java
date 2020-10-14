package design.patterns.adapter.p01.type;

public class AdapterTest {

	public static void main(String[] args) {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}
