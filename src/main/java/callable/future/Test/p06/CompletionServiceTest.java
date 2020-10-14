package callable.future.Test.p06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * https://www.cnblogs.com/skyblog/p/6145299.html
 *
 */
public class CompletionServiceTest {

	static int numThread = 100;
	static ExecutorService executor = Executors.newFixedThreadPool(numThread);

	public static void main(String[] args) throws Exception {
		// data表示批量任务
		int[] data = new int[100];
		for (int i = 1; i < 100000; i++) {
			int idx = i % 100;
			data[idx] = i;
			if (i % 100 == 0) {
				testCompletionService(data);
				data = new int[100];
			}
		}
	}

	private static void testCompletionService(int[] data) throws Exception {
		CompletionService<Object> ecs = new ExecutorCompletionService<Object>(executor);
		for (int i = 0; i < data.length; i++) {
			final Integer t = data[i];
			ecs.submit(new Callable<Object>() {
				public Object call() {
					try {
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return t;
				}
			});
		}
		// CompletionService会按处理完后顺序返回结果
		List<Object> res = new ArrayList<Object>();
		for (int i = 0; i < data.length; i++) {
			Future<Object> f = ecs.take();
			res.add(f.get());
		}
		System.out.println(Thread.currentThread().getName() + ":" + res);
	}

	private static void testBasicFuture(int[] data) throws Exception {
		List<Future<Object>> res = new ArrayList<Future<Object>>();
		for (int i = 0; i < data.length; i++) {
			final Integer t = data[i];
			Future<Object> future = executor.submit(new Callable<Object>() {
				public Object call() {
					return t;
				}
			});
			res.add(future);
		}

		for (int i = 0; i < res.size(); i++) {
			Future<Object> f = res.get(i);
			Object rObject = f.get();
			System.out.print(":" + rObject);
		}
		System.out.println("LN");
	}
}