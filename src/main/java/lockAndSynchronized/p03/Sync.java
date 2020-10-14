package lockAndSynchronized.p03;

class Sync {
	
	private Object lock = new Object();
	
	public void test() {
//		synchronized (this) {
		synchronized (lock) {
			System.out.println("test开始..");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test结束..");
		}
	}
	
//	public void other() {
//		System.out.println("I am other");
//	}
	
	public synchronized void other() {
		System.out.println("I am other");
	}
}