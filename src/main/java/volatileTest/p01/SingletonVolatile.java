package volatileTest.p01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingletonVolatile {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<Singleton>> futureList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			futureList.add(threadPool.submit(new SingletonCallable()));
		}
		threadPool.shutdown();
		for (Future<Singleton> future : futureList) {
			Singleton singleton = future.get();
			singleton.hello();
		}
	}

}

class SingletonCallable implements Callable<Singleton> {

	@Override
	public Singleton call() throws Exception {
		return Singleton.getInstance();
	}

}

class Singleton {

//	public static volatile Singleton singleton;
	public static Singleton singleton;

	public void hello() {
		System.out.println("hello");
	}
	
	public static Singleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(Singleton singleton) {
		Singleton.singleton = singleton;
	}

	/**
	 * 构造函数私有，禁止外部实例化
	 */
	private Singleton() {
	};

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}