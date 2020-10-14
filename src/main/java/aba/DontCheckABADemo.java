package aba;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 无法检测到ABA是否发生
 * <p>
 * https://blog.csdn.net/sixidea/article/details/84441104
 * 
 * @author
 */
public class DontCheckABADemo {

	/**
	 * 把邮件内容“远方的问候”放到了一个普通信封envelope里 envelope = 邮件内容
	 */
	static AtomicReference<String> envelope = new AtomicReference<String>("远方的来信");

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// 线程1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				String mailContent = envelope.get();

				System.out.println("T1首先看到了信封里的邮件内容[ " + mailContent + " ]（A）。");

				try {
					// T1被强制sleep一会，好让T2这个时候有机可乘
					System.out.println("T1现在有事情暂时的离开了一小会。");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				boolean result = envelope.compareAndSet(mailContent, "远方的回信");
				if (result) {
					System.out.println("\nT1在返回后重新检查了邮件，好像没人动过。" + "现在可以写回信了[ " + envelope.get() + " ]。");
				}
			}
		});

		// 线程2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					// T2先sleep一会，好让T1有机会先看到信封里面的邮件内容
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				String mailContent = envelope.get();

				// T2第一次修改了信封里的邮件内容
				boolean firstOpt = envelope.compareAndSet(mailContent, "");
				if (firstOpt)
					System.out.println("\nT2悄悄将信封里的邮件内容[ " + mailContent + " ]取走（B）。" + "现在邮件内容已经不再信封里了。");

				// T2第二次修改了信封里的邮件内容
				boolean secondOpt = envelope.compareAndSet("", mailContent);

				if (secondOpt)
					System.out.println("T2悄悄把信封里的邮件内容[ " + envelope.get() + " ]放回（A）。" + "现在邮件内容好像没被动过一样。");
			}
		});

		t1.start();
		t2.start();
	}
}