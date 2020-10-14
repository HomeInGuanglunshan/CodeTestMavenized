package inheritTest;

public class MainTest {

	public static void main(String[] args) {
		Father f = new Son(); // 注意这个地方
		Son s = new Son();
		f.f();
		((Son) f).s();
		((Father) s).f();
	}

}
