package threadTest.threadTest08.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer extends Thread {

	AtomicInteger storage;

	public Consumer(AtomicInteger storage, String name) {
		setName(name);
		this.storage = storage;
	}

	@Override
	public void run() {
		for (;;) {
			synchronized (storage) {
				if (storage.get() <= 0) {
					try {
						storage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.print(storage + " - 1 = " + storage.decrementAndGet());
					System.out.println(" [" + getName() + "]");
					storage.notifyAll();
				}
			}
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
