package lockTest.p07.trylock.csdn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://blog.csdn.net/michaelgo/article/details/81481068
 */
public class TestLockAndTryLock2 {
	private ReentrantLock rlock = new ReentrantLock();

	private void lockTest() {
		long currentTime = System.currentTimeMillis();
		try {
			rlock.lock();

			System.out.println("lockTest----current thread get the lock: " + Thread.currentThread().getName());

			while (System.currentTimeMillis() - currentTime <= 5000) {
				//assume do something
			}

		} finally {
			rlock.unlock();
			System.out.println("lockTest----current thread release the lock:  " + Thread.currentThread().getName());
		}
	}

	@SuppressWarnings("unused")
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

	private void tryLockInterruptTest() {

		long currentTime = System.currentTimeMillis();

		while (System.currentTimeMillis() - currentTime <= 100) {
			//assume do something
		}

		try {
			System.out.println("Begin time: " + System.currentTimeMillis());
			if (rlock.tryLock(1, TimeUnit.SECONDS)) {
				try {
					System.out.println(
							"tryLockInterruptTest----current thread get the lock: " + Thread.currentThread().getName());

				} finally {
					rlock.unlock();
					System.out.println("tryLockInterruptTest----current thread release the lock: "
							+ Thread.currentThread().getName());
				}

			} else {
				System.out.println("End time: " + System.currentTimeMillis());
				System.out.println("tryLockInterruptTest----current thread CAN NOT get the lock: "
						+ Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		TestLockAndTryLock2 lockAndTryLock = new TestLockAndTryLock2();

		Thread lockThread = new Thread(() -> lockAndTryLock.lockTest(), "Lock-Thread");

		Thread tryLockInterruptThread = new Thread(() -> lockAndTryLock.tryLockInterruptTest(),
				"TryLockInterrupt-Thread");

		tryLockInterruptThread.start();
		lockThread.start();

	}

}