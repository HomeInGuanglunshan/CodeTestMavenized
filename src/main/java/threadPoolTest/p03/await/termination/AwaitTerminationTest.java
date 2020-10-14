package threadPoolTest.p03.await.termination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationTest {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
//		threadPool.shutdown();
		try {
			Thread.sleep(2000);
//			threadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
//			threadPool.awaitTermination(1000, TimeUnit.MILLISECONDS);
			System.out.println(threadPool.getActiveCount());
			System.out.println(threadPool.awaitTermination(2000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
