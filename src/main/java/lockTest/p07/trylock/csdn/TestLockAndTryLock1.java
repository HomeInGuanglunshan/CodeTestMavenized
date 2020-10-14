package lockTest.p07.trylock.csdn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/michaelgo/article/details/81481068
 */
public class TestLockAndTryLock1 {
	private ReentrantLock rlock = new ReentrantLock();

	private void lockTest() {
		long currentTime = System.currentTimeMillis();
		try {
			rlock.lock();

			while (System.currentTimeMillis() - currentTime <= 1000) {
				//assume do something
			}
			System.out.println("lockTest----current thread get the lock: " + Thread.currentThread().getName());
		} finally {
			rlock.unlock();
			System.out.println("lockTest----current thread release the lock:  " + Thread.currentThread().getName());
		}
	}

	private void tryLockTest() {

		long currentTime = System.currentTimeMillis();

		while (System.currentTimeMillis() - currentTime <= 100) {
			//assume do something
		}

		if (rlock.tryLock()) {
			try {
				System.out.println("tryLockTest----current thread get the lock: " + Thread.currentThread().getName());

			} finally {
				rlock.unlock();
				System.out
						.println("tryLockTest----current thread release the lock: " + Thread.currentThread().getName());
			}

		} else {
			System.out
					.println("tryLockTest----current thread CAN NOT get the lock: " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {

		TestLockAndTryLock1 lockAndTryLock = new TestLockAndTryLock1();

		Thread lockThread = new Thread(() -> lockAndTryLock.lockTest(), "Lock-Thread");

		Thread tryLockThread = new Thread(() -> lockAndTryLock.tryLockTest(), "TryLock-Thread");

		tryLockThread.start();
		lockThread.start();

	}

}