package threadTest.threadTest08.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {

	AtomicInteger storage;

	public Producer(AtomicInteger storage, String name) {
		setName(name);
		this.storage = storage;
	}

	@Override
	public void run() {
		for (;;) {
			synchronized (storage) {
				if (storage.get() >= 5) {
					try {
						storage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.print(storage + " + 1 = " + storage.incrementAndGet());
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
