package threadLocalTest.threadLocalTest2;

public class ThreadLocalTest1 {

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
		new Thread(new Runnable() {

			@Override
			public void run() {
				setTime(sleep);
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getTime());
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
		ThreadLocalTest1 t = new ThreadLocalTest1();
		
		t.myThread(3000);
		t.myThread(1000);
		
//		new ThreadLocalTest().myThread(3000);
//		new ThreadLocalTest().myThread(1000);
		
//		t.myThread2(3000);
//		t.myThread2(1000);
	}

}
