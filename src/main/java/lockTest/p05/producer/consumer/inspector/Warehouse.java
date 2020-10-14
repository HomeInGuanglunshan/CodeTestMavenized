package lockTest.p05.producer.consumer.inspector;

import java.math.BigDecimal;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Warehouse {

	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	Condition inCondition = lock.writeLock().newCondition();
	Condition outCondition = lock.writeLock().newCondition();

	volatile Integer storage;
	volatile Integer capacity;

	public Warehouse(Integer storage, Integer capacity) {
		this.storage = storage;
		this.capacity = capacity;
	}

	public void in() {
		try {
			lock.writeLock().lock();
			for (; storage >= capacity;) {
				inCondition.await();
			}
			System.out.print(storage + " + 1 = " + ++storage);
			System.out.println(" [" + Thread.currentThread().getName() + "]");
			outCondition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void out() {
		try {
			lock.writeLock().lock();
			for (; storage <= 0;) {
				outCondition.await();
			}
			System.out.print(storage + " - 1 = " + --storage);
			System.out.println(" [" + Thread.currentThread().getName() + "]");
			inCondition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void check() {
		try {
			lock.readLock().lock();
			// If the warehouse is too full, reduce its storage to 70%
			if (storage > capacity * 0.7) {
				lock.readLock().unlock();
				lock.writeLock().lock();
				// Recheck state because another thread might have acquired
				// write lock and changed state before we did.
				if (storage > capacity * 0.7) {
					Integer formerVal = storage;
					storage = new BigDecimal(capacity * 0.7).intValue();
					System.err.print(formerVal + " => " + storage);
					System.err.println(" [" + Thread.currentThread().getName() + "]");
				}
				lock.readLock().lock();
				lock.writeLock().unlock();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
}
