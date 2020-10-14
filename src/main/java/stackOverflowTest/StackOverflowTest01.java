package stackOverflowTest;

public class StackOverflowTest01 {

	StackOverflowTest01 instance = new StackOverflowTest01();

	public void test(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I HAVE SLEPT FOR " + time + " MILLISECONDS");
	}

	public void testInMain() {
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
	
	public static void main(String[] args) {
		new StackOverflowTest01().testInMain();
	}

}
