package lockTest.p06.p.c.i.reentrantlock;

import java.math.BigDecimal;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {

	ReentrantLock lock = new ReentrantLock();

	Condition inCondition = lock.newCondition();
	Condition outCondition = lock.newCondition();

	volatile Integer storage;
	volatile Integer capacity;

	public Warehouse(Integer storage, Integer capacity) {
		this.storage = storage;
		this.capacity = capacity;
	}

	public void in() {
		try {
			lock.lock();
			for (; storage >= capacity;) {
				inCondition.await();
			}
			System.out.print(storage + " + 1 = " + ++storage);
			System.out.println(" [" + Thread.currentThread().getName() + "]");
			outCondition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void out() {
		try {
			lock.lock();
			for (; storage <= 0;) {
				outCondition.await();
			}
			System.out.print(storage + " - 1 = " + --storage);
			System.out.println(" [" + Thread.currentThread().getName() + "]");
			inCondition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void check() {
		try {
			lock.lock();
			// If the warehouse is too full, reduce its storage to 70%
			if (storage > capacity * 0.7) {
				Integer formerVal = storage;
				storage = new BigDecimal(capacity * 0.7).intValue();
				System.err.print(formerVal + " => " + storage);
				System.err.println(" [" + Thread.currentThread().getName() + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
