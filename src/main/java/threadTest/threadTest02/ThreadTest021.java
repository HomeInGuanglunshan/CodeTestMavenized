package threadTest.threadTest02;

public class ThreadTest021 {

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
				new ThreadTest021().test(10000);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				new ThreadTest021().test(2000);
			}
		}).start();
	}

}
