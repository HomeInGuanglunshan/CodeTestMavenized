package threadTest.threadTest02;

public class ThreadTest024 {

	static ThreadTest024 instance = new ThreadTest024();

	public void test(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I HAVE SLEPT FOR " + time + " MILLISECONDS");
	}

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				instance.test(10000);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				instance.test(2000);
			}
		}).start();
	}

}
