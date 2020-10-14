package lockAndSynchronized.p04;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Toilet {

	Integer shits = 0;

	public synchronized void shit() {
		@SuppressWarnings("unused")
		int i = 1 / new Random().nextInt(3);
		shits++;
	}

	public Integer count() {
		return shits;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Toilet toilet = new Toilet();
		for (int i = 0; i < 10; i++) {
			threadPool.execute(() -> {
				try {
					toilet.shit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		threadPool.shutdown();
		for (; !threadPool.awaitTermination(1, TimeUnit.MILLISECONDS);)
			;
		System.out.println(toilet.count());
	}

}
