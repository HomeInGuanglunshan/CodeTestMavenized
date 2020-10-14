package threadTest.threadTest02;

public class ThreadTest023 {

	public void test(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I HAVE SLEPT FOR " + time + " MILLISECONDS");
	}

	public static void main(String[] args) {
		ThreadTest023 s = new ThreadTest023();
		s.test(10000);
		s.test(2000);
	}

}
