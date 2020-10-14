package threadTest.threadTest08.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class ProConTest {

	public static void main(String[] args) {
		AtomicInteger storage = new AtomicInteger(5);
		new Consumer(storage, "Consumer1").start();
		new Consumer(storage, "Consumer2").start();
		new Producer(storage, "Producer1").start();
		new Producer(storage, "Producer2").start();
	}
}
