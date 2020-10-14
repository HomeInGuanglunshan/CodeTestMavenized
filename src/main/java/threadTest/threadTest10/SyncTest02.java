package threadTest.threadTest10;

public class SyncTest02 {

	private final Object setLock = new Object();

	private final Object getLock = new Object();

	public void set() {
		synchronized (setLock) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " has set");
		}
	}

	public void get() {
		synchronized (getLock) {
			System.out.println(Thread.currentThread().getName() + " has got");
		}
	}

	public static void main(String[] args) {
		SyncTest02 syncTest = new SyncTest02();
		new Thread(new Runnable() {
			@Override
			public void run() {
				syncTest.set();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				syncTest.set();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				syncTest.get();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				syncTest.get();
			}
		}).start();
	}

}
