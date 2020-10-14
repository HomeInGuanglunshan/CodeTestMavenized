package lockTest.p02.read.write.lock.my.test.v02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RepositoryTest {

	public static void main(String[] args) throws Exception {
		ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		Repository repository = new Repository(100, 200);
		for (int i = 0; i < 100; i++) {
			final int symbol = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					Integer goods = new Random().nextInt(100);
					if (symbol % 2 == 0) {
						repository.deliverIn(goods);
					} else {
						repository.deliverOut(goods);
					}
				}
			});
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) {
					if (threadPool.getActiveCount() > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						threadPool.shutdown();
						System.out.println("threadPool shutdown");
						break;
					}
				}
			}
		}).start();
		
		Thread consoleReader = new Thread(new Runnable() {
			@Override
			public void run() {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String input = null;
				for (;;) {
					for (;;) {
						try {
							input = br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (!input.matches("[\\-\\+\\?@]+")) {
							System.err.println("invalid input");
							continue;
						} else {
							break;
						}
					}
					
					for (char c : input.toCharArray()) {
						Integer goods = new Random().nextInt(100);
						if ('-' == c) {
							threadPool.execute(new Runnable() {
								@Override
								public void run() {
									repository.deliverOut(goods);
								}
							});
						} else if ('+' == c) {
							threadPool.execute(new Runnable() {
								@Override
								public void run() {
									repository.deliverIn(goods);
								}
							});
						} else if ('?' == c) {
							threadPool.execute(new Runnable() {
								@Override
								public void run() {
									repository.signalAll();
								}
							});
						} else {
							threadPool.execute(new Runnable() {
								@Override
								public void run() {
									System.err.println(repository);
								}
							});
						}
					}
				}
			}
		});
		consoleReader.setDaemon(true);
		consoleReader.start();
	}
}