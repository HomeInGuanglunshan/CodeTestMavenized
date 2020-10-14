package threadTest.threadTest04.priority;
class firstFamilyThread implements Runnable {
	Thread thread;// 声明一个线程
	public firstFamilyThread() {
	}
 
	public firstFamilyThread(String name) {// 构造方法初始化一个线程
		thread = new Thread(this, name); // 参数1 是要调用的线程thread， 参数2
											// 是要调用的线程thread的名字
	}
 
	@Override
	public void run() {
		System.out.println("第一家族人员：" + thread.getName());// 获得线程的名称
	}
 
	public void startThreadByLevel() {// 该方法创建5个线程，并各赋予不同的优先级
		// 实例化5个类对象，在调用的一参构造器中创建线程
		firstFamilyThread f1 = new firstFamilyThread("爷爷");
		firstFamilyThread f2 = new firstFamilyThread("奶奶");
		firstFamilyThread f3 = new firstFamilyThread("爸爸");
		firstFamilyThread f4 = new firstFamilyThread("妈妈");
		firstFamilyThread f5 = new firstFamilyThread("我");
		// 设置线程优先级-调用全局变量thread，然后设置优先级
		f1.thread.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY 10
		f2.thread.setPriority(Thread.MAX_PRIORITY-1);//9
		f3.thread.setPriority(Thread.NORM_PRIORITY);//NORM_PRIORITY 5
		f4.thread.setPriority(Thread.NORM_PRIORITY-1);//4
		f5.thread.setPriority(Thread.MIN_PRIORITY);//MIN_PRIORITY 1
		f1.thread.start();
		f2.thread.start();
		f3.thread.start();
		f4.thread.start();
		f5.thread.start();
		try {
			f5.thread.join();
		} catch (InterruptedException e) {
			System.out.println("等待线程结束出错： "+e.getMessage());
		}
	}
 
}
class secondFamilyThread implements Runnable {
	Thread thread;// 声明一个线程
	public secondFamilyThread() {
	}
 
	public secondFamilyThread(String name) {// 构造方法初始化一个线程
		thread = new Thread(this, name); // 参数1 是要调用的线程thread， 参数2
											// 是要调用的线程thread的名字
	}
 
	@Override
	public void run() {
		System.out.println("第二家族人员：" + thread.getName());// 获得线程的名称
	}
 
	public void startThreadByLevel() {// 该方法创建5个线程，并各赋予不同的优先级
		// 实例化5个类对象，在调用的一参构造器中创建线程
		secondFamilyThread s1 = new secondFamilyThread("爷爷");
		secondFamilyThread s2 = new secondFamilyThread("奶奶");
		secondFamilyThread s3 = new secondFamilyThread("爸爸");
		secondFamilyThread s4 = new secondFamilyThread("妈妈");
		secondFamilyThread s5 = new secondFamilyThread("我");
		// 设置线程优先级-调用全局变量thread，然后设置优先级
		s1.thread.setPriority(10);//MAX_PRIORITY 10
		s2.thread.setPriority(9);//9
		s3.thread.setPriority(5);//NORM_PRIORITY 5
		s4.thread.setPriority(4);//4
		s5.thread.setPriority(1);//MIN_PRIORITY 1
		s1.thread.start();
		s2.thread.start();
		s3.thread.start();
		s4.thread.start();
		s5.thread.start();
		try {
			s5.thread.join();
		} catch (InterruptedException e) {
			System.out.println("等待线程结束出错： "+e.getMessage());
		}
	}
 
}
public class TextPriorityLevel extends Thread {// 操作运用优先级实现家族等级
	public static void main(String[] args) {
		System.out.println("实现Runnable接口，根据静态等级常量实现线程优先级");
		new firstFamilyThread().startThreadByLevel();
		System.out.println("实现Runnable接口，根据数字从高到低实现线程优先级");
		new secondFamilyThread().startThreadByLevel();
	}
}
