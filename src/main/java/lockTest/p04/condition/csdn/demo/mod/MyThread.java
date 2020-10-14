package lockTest.p04.condition.csdn.demo.mod;

public class MyThread extends Thread {
	
	private String todo;
	private MyService myService;

	public MyThread(String todo, MyService myService) {
		this.todo = todo;
		this.myService = myService;
	}

	@Override
	public void run() {
		if ("await".equals(todo)) {
			myService.await();
		} else if ("signal".equals(todo)) {
			myService.signal();
		}
	}
}