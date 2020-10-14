package singletonTest.singletonTest1;

public class Singleton2 extends Thread {
	private static Singleton2 instance;

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}