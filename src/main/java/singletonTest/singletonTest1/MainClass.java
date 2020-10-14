package singletonTest.singletonTest1;

public class MainClass extends Thread {

	public void run() {
		System.out.println(Singleton.getInstance());
	}

	public static void main(String[] args) {
		// if (Singleton.getInstance() == Singleton.getInstance()) {
		// System.out.println(true);
		// }
		MainClass m = new MainClass();
		MainClass m1 = new MainClass();
		m.start();
		m1.start();
	}

}
