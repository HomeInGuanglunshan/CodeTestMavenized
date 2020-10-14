package volatileTest;

public class VolatileExample extends Thread {
	// 设置类静态变量,各线程访问这同一共享变量
	private static boolean flag = false;
	// private static volatile boolean flag = false;

	// 无限循环,等待flag变为true时才跳出循环
	public void run() {
		while (!flag) {
			// int i = 0;
			// 推测以下代码输出到一定程度的时候，达到上限，逼停while循环。如果没有以下这行代码，while循环会一直持续下去。以上代码则不会有问题。
			// System.out.println("hello");
		}
	}

	public static void main(String[] args) throws Exception {
		new VolatileExample().start();
		// sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了
		Thread.sleep(100);
		flag = true;
	}

}