package lockTest.p08.trylock;

public class DeadLock {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (a) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (b) {
						System.out.println("a -> b");
					}
				}
			}
		}, "Thread-a-b").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (b) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (a) {
						System.out.println("b -> a");
					}
				}
			}
		}, "Thread-b-a").start();
	}

}
