package callable.future.Test.p08;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderedResults2 {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<String>> futures = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			final Integer symbol = i;
			Callable<String> task = () -> {
				Thread.sleep(new Random().nextInt(1000));
				String finishTime = new SimpleDateFormat("HH:mm:ss SSS").format(new Date());
				return symbol + " was finished on " + finishTime;
			};
			futures.add(threadPool.submit(task));
		}
		threadPool.shutdown();
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
	}

}
