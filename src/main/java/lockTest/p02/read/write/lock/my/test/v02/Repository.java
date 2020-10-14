package lockTest.p02.read.write.lock.my.test.v02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Repository {

	ReentrantReadWriteLock repositoryLock = new ReentrantReadWriteLock();

	Condition conditionIn = repositoryLock.writeLock().newCondition();
	Condition conditionOut = repositoryLock.writeLock().newCondition();
	
	Integer goods;

	Integer capacity;

	public Repository(Integer goods, Integer capacity) {
		super();
		this.goods = goods;
		this.capacity = capacity;
	}

	public Integer getGoods() {
		return goods;
	}

	public void setGoods(Integer goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "当前仓库存量：" + this.goods + "，容量：" + this.capacity;
	}
	
	public void deliverIn(Integer goods) {
		try {
			repositoryLock.writeLock().lock();
			for (;;) {
				if ((this.goods + goods - capacity) <= 0) {
					setGoods(this.goods + goods);
					System.out.println(Thread.currentThread().getName() + "，入库：" + goods + "，当前仓库存储量：" + getGoods());
					conditionOut.signal();
					break;
				} else {
					System.err.println(Thread.currentThread().getName() + "，入库：" + goods + "，库存已满，库外等候");
					conditionIn.await();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			repositoryLock.writeLock().unlock();
		}
	}

	public void deliverOut(Integer goods) {
		try {
			repositoryLock.writeLock().lock();
			for (;;) {
				if ((this.goods - goods) >= 0) {
					setGoods(this.goods - goods);
					System.out.println(Thread.currentThread().getName() + "，出库：" + goods + "，当前仓库存储量：" + getGoods());
					conditionIn.signal();
					break;
				} else {
					System.err.println(Thread.currentThread().getName() + "，出库：" + goods + "，库存已空，等待进货");
					conditionOut.await();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			repositoryLock.writeLock().unlock();
		}
	}
	
	public void signalAll() {
		repositoryLock.writeLock().lock();
		conditionIn.signalAll();
		conditionOut.signalAll();
		repositoryLock.writeLock().unlock();
	}
}
