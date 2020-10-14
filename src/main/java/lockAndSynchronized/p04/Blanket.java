package lockAndSynchronized.p04;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Blanket {

	Integer eggs = 0;

	ReentrantLock reentrantLock = new ReentrantLock();

	public void put() throws Exception {
		try {
			for (; !reentrantLock.tryLock(1, TimeUnit.MILLISECONDS);)
				;
			@SuppressWarnings("unused")
			int i = 1 / new Random().nextInt(3);
			eggs++;
			reentrantLock.unlock();
		} finally {
			try {
//				reentrantLock.unlock();
			} catch (Exception e) {
			}
		}
	}

	public Integer count() {
		return eggs;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Blanket blanket = new Blanket();
		for (int i = 0; i < 10; i++) {
			threadPool.execute(() -> {
				try {
					blanket.put();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		threadPool.shutdown();
		for (; !threadPool.awaitTermination(1, TimeUnit.MILLISECONDS);)
			;
		System.out.println(blanket.count());
	}

}
