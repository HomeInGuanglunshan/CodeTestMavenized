package threadLocalTest.threadLocalTest2;

public class ThreadLocalTest2 {

	private static ThreadLocal<Integer> want = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};
	
	public int time;
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void myThread(final int sleep) {
		final int ofThread = sleep;
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(ofThread);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(ofThread);
			}
			
		}).start();
	}
	
	public void myThread2(final int sleep) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				want.set(sleep);
				try {
					Thread.sleep(want.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(want.get());
			}
			
		}).start();
	}
	
	public static void main(String[] args) {
		ThreadLocalTest2 t = new ThreadLocalTest2();
		
		t.myThread(3000);
		t.myThread(1000);
	}

}
