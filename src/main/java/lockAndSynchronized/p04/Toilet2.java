package lockAndSynchronized.p04;

import java.util.Random;

public class Toilet2 {

	Integer shits = 0;

	public synchronized void shit() {
		@SuppressWarnings("unused")
		int i = 1 / new Random().nextInt(3);
		shits++;
	}

	public Integer count() {
		return shits;
	}

	public static void main(String[] args) throws Exception {
		Toilet2 toilet = new Toilet2();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + " starts");
					toilet.shit();
					System.out.println(Thread.currentThread().getName() + " ends");
				} catch (Exception e) {
					System.out.println(Thread.currentThread().getName() + " fails");
					e.printStackTrace();
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(toilet.count());
	}

}
