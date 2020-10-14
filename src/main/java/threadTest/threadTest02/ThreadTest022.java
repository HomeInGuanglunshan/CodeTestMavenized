package threadTest.threadTest02;

public class ThreadTest022 {

	public void test(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I HAVE SLEPT FOR " + time + " MILLISECONDS");
	}

	public static void main(String[] args) {
		new ThreadTest022().test(10000);
		new ThreadTest022().test(2000);
	}

}
