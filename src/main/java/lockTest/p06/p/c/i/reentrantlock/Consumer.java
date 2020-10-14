package lockTest.p06.p.c.i.reentrantlock;

import java.util.Random;

public class Consumer extends Thread {

	Warehouse warehouse;

	public Consumer(Warehouse warehouse, String name) {
		setName(name);
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		for (;;) {
			warehouse.out();
			try {
				sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
