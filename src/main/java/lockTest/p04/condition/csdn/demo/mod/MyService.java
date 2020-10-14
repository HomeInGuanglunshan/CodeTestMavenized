package lockTest.p04.condition.csdn.demo.mod;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyService {
	private Lock lock = new ReentrantReadWriteLock().writeLock();
	private Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + ", await, 时间为: " + System.currentTimeMillis());
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + ", signal, 时间为: " + System.currentTimeMillis());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}