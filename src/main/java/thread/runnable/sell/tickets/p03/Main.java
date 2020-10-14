package thread.runnable.sell.tickets.p03;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
	}

}
