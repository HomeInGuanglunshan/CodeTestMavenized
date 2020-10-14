package callable.future.Test.p04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		for (int i = 1; i <= 5; i++) {
			final int taskID = i;
			futureList.add(cs.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					return taskID;
				}
			}));
		}
		// 可能做一些事情
		for (Future<Integer> future : futureList) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 5; i++) {
			try {
				System.out.println(cs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		threadPool.shutdown();
	}
}