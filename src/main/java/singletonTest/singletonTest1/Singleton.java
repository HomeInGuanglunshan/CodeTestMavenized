package singletonTest.singletonTest1;

public class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton s = new Singleton();
		Singleton s1 = new Singleton();
		System.out.println(s);
		System.out.println(s1);
	}
}