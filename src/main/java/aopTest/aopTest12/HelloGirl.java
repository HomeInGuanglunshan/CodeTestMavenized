package aopTest.aopTest12;

public class HelloGirl {

	@Asynchronous
	public void sayHelloTenTimes() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("hello!");
		}
	}

	@Asynchronous
	public void sayHiTenTimes() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("hi!");
		}
	}

	public void sayHelloAndHi() {
		sayHelloTenTimes();
		sayHiTenTimes();
	}

	public void sayGoodbye() {
		System.out.println("goodbye!");
	}
}
