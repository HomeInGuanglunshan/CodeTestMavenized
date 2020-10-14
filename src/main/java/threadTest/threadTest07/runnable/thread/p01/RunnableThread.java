package threadTest.threadTest07.runnable.thread.p01;

public class RunnableThread extends Thread {

	int bullets = 100;

	@Override
	public void run() {
		shoot();
	}

	private void shoot() {
		for (; bullets > 0;) {
			System.out.println(--bullets + " bullets remains in the pocket of " + getName() + ".");
		}
	}

	public static void main(String[] args) {
		new RunnableThread().start();
		new RunnableThread().start();
		new RunnableThread().start();
	}
}
