package threadTest.threadTest01;

public class ThreadTest01 {
	
	public static void father() throws InterruptedException {
		System.out.println("FATHER BEGINS");
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					son();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
		System.out.println("FATHER ENDS");
	}
	
	public static void son() throws InterruptedException {
		System.out.println("SON BEGINS");
		Thread.sleep(3000);
		System.out.println("SON ENDS");
	}
	
	public static void otherFather() throws InterruptedException {
		System.out.println("FATHER BEGINS");
		otherSon();
		System.out.println("FATHER ENDS");
	}
	
	public static void otherSon() throws InterruptedException {
		System.out.println("SON BEGINS");
		Thread.sleep(3000);
		System.out.println("SON ENDS");
	}
	
	public static void main(String[] args) throws InterruptedException {
//		father();
		otherFather();
	}
}
