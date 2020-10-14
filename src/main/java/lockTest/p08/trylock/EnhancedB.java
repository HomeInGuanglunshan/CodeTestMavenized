package lockTest.p08.trylock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class EnhancedB {

	ReentrantLock reentrantLock = new ReentrantLock();

//	public boolean occupy() {
//		try {
//			int i = 10;
//			while (i > 0 && !reentrantLock.tryLock(500, TimeUnit.MILLISECONDS)) {
//				i--;
//			}
//			return i > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

	public boolean occupy() {
		try {
//			return reentrantLock.tryLock(500, TimeUnit.MILLISECONDS);
			return reentrantLock.tryLock(new Random().nextInt(1000), TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void release() {
		reentrantLock.unlock();
	}
}
