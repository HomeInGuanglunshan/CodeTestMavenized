package threadTest.threadTest07.runnable.thread.p02;

public class RunnableThread implements Runnable {

	int bullets = 100;

	@Override
	public void run() {
		shoot();
	}

	private void shoot() {
		for (; bullets > 0;) {
			System.out
					.println(--bullets + " bullets remains in the pocket of " + Thread.currentThread().getName() + ".");
		}
	}

	public static void main(String[] args) {
		RunnableThread runnableThread = new RunnableThread();
		new Thread(runnableThread).start();
		new Thread(runnableThread).start();
		new Thread(runnableThread).start();
	}
}
