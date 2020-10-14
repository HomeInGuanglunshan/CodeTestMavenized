package threadTest.threadTest06.run.start;

public class RunAndStart extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(getName() + " is sleeping.");
				sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " is working.");
	}

	public static void main(String[] args) {
		RunAndStart runAndStart = new RunAndStart();
		runAndStart.start();
		for (int i = 0; i < 5; i++) {
			System.out.println(23333);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//		RunAndStart runAndStart = new RunAndStart();
//		runAndStart.run();
//		for (int i = 0; i < 5; i++) {
//			System.out.println(23333);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
