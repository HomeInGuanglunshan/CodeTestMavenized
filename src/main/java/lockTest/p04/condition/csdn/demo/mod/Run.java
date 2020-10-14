package lockTest.p04.condition.csdn.demo.mod;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		
		MyService myService = new MyService();
		
		MyThread t1 = new MyThread("await", myService);
		t1.start();
		MyThread t2 = new MyThread("await", myService);
		t2.start();
		MyThread t3 = new MyThread("signal", myService);
		t3.start();
		
		Thread.sleep(1000);
		
		myService.signal();
	}
}
