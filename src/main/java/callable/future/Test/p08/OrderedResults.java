package callable.future.Test.p08;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OrderedResults {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// CompletionService是一个结果容器的存在
		CompletionService<String> completionService = new ExecutorCompletionService<>(threadPool);
		for (int i = 0; i < 1000; i++) {
			final Integer symbol = i;
			Callable<String> task = () -> {
				Thread.sleep(new Random().nextInt(1000));
				String finishTime = new SimpleDateFormat("HH:mm:ss SSS").format(new Date());
				return symbol + " was finished on " + finishTime;
			};
			completionService.submit(task);
//			completionService.submit(() -> "aaa");
		}
//		for (Future<String> future; (future = completionService.poll()) != null;) { // 鲜见输出
//			System.out.println(future.get());
//		}
		for (Future<String> future; (future = completionService.poll(1000, TimeUnit.MILLISECONDS)) != null;) {
			System.out.println(future.get());
		}
//		for (Future<String> future; (future = completionService.take()) != null;) { // 线程池shutdown失败，目前不清楚原因
//			System.out.println(future.get());
//		}
		threadPool.shutdown();
	}

}
