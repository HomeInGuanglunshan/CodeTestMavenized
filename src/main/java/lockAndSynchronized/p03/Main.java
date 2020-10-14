package lockAndSynchronized.p03;

class MyThread extends Thread {

	private Sync sync;

	public MyThread(Sync sync) {
		this.sync = sync;
	}

	public void run() {
		sync.test();
	}
}

class YourThread extends Thread {

	private Sync sync;

	public YourThread(Sync sync) {
		this.sync = sync;
	}

	public void run() {
		for (int i = 0; i < 10 ; i++) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sync.other();
		}
	}
}

public class Main {

	public static void main(String[] args) {
		Sync sync = new Sync();
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread(sync);
			thread.start();
		}
		Thread yourThread = new YourThread(sync);
		yourThread.start();
	}
}