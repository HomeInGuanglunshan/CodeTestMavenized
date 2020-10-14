package lockTest.p06.p.c.i.reentrantlock;

import java.util.Random;

public class Inspector extends Thread {

	Warehouse warehouse;

	public Inspector(Warehouse warehouse, String name) {
		setName(name);
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		for (;;) {
			warehouse.check();
			try {
				sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
