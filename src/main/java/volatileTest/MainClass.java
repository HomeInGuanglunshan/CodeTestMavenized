package volatileTest;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		StoppableTask s1 = new StoppableTask();
		StoppableTask s2 = new StoppableTask();
		s1.start();
		Thread.sleep(100);
		s1.tellMeToStop();
		// 以下的s2没反应,但以上的s1有反应
		// s2.tellMeToStop();
	}

}
