package lockAndSynchronized.p04;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Blanket2 {

	Integer eggs = 0;

	ReentrantLock reentrantLock = new ReentrantLock(true);

	public void put() {
		try {
			System.out.println(Thread.currentThread().getName() + " starts");
//			不知为何，此举无法使用公平锁
//			for (; !reentrantLock.tryLock(2000, TimeUnit.MILLISECONDS);)
//				;
			reentrantLock.lock();

			@SuppressWarnings("unused")
			int i = 1 / new Random().nextInt(3);
			eggs++;

			System.out.println(Thread.currentThread().getName() + " ends");
			reentrantLock.unlock();
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " fails");
			e.printStackTrace();
			reentrantLock.unlock();
		}
	}

	public Integer count() {
		return eggs;
	}

	public static void main(String[] args) throws Exception {
		Blanket2 blanket = new Blanket2();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				blanket.put();
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(blanket.count());
	}

}
