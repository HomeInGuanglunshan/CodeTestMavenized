package lockTest.p08.trylock;

public class NotDeadLock {

	public static void main(String[] args) {

		EnhancedA enhancedA = new EnhancedA();
		EnhancedB enhancedB = new EnhancedB();

		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean ab = false;
				for (int i = 0; i < 10; i++) {
					if (enhancedA.occupy()) {
						if (enhancedB.occupy()) {
							ab = true;
							enhancedB.release();
						} else {
							System.out.println("Thread-A-b will try again");
						}
						enhancedA.release();
					}
				}
				System.out.println("Thread-A-b " + (ab ? "succeeds" : "fails"));
			}
		}, "Thread-A-b").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean ba = false;
				for (int i = 0; i < 10; i++) {
					if (enhancedB.occupy()) {
						if (enhancedA.occupy()) {
							ba = true;
							enhancedA.release();
						} else {
							System.out.println("Thread-B-a will try again");
						}
						enhancedB.release();
					}
				}
				System.out.println("Thread-B-a " + (ba ? "succeeds" : "fails"));
			}
		}, "Thread-B-a").start();
	}

}
