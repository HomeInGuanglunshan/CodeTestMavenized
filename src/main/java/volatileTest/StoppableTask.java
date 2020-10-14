package volatileTest;

public class StoppableTask extends Thread {

	private volatile boolean pleaseStop;

	public void run() {
		while (!pleaseStop) {
		}
	}

	public void tellMeToStop() {
		pleaseStop = true;
	}

}