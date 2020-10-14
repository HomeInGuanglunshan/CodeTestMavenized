package threadTest.threadTest10;

public class SyncTest {

	public synchronized void set() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has set");
	}

	public synchronized void get() {
		System.out.println(Thread.currentThread().getName() + " has got");
	}

//	public void get() {
//		System.out.println(Thread.currentThread().getName() + " has got");
//	}

	public static void main(String[] args) {
		SyncTest syncTest = new SyncTest();
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
