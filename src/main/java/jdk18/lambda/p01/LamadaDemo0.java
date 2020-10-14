package jdk18.lambda.p01;

/**
 * https://blog.csdn.net/wzj_110/article/details/80201470
 */
public class LamadaDemo0 {
	public static void main(String[] args) {

		//匿名内部类的形式开启一个线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我爱你！");
			}
		}).start();

		//Lambada表达式创建匿名内部类开启一个线程
		new Thread(() -> System.out.println("-------------")).start();
	}
}