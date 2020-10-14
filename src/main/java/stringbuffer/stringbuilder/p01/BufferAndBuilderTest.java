package stringbuffer.stringbuilder.p01;

public class BufferAndBuilderTest {

	
	public static void main(String[] args) {
		
		final StringBuffer sbf = new StringBuffer("");
		
		final StringBuilder sbd = new StringBuilder("");
		
		// 线程数越多越明显
		for (int i = 0; i < 100000; i++) {
			new Thread(new Runnable(){
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					sbf.append("a");
				}
				
			}).start();
		}
		
		for (int i = 0; i < 100000; i++) {
			new Thread(new Runnable(){
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					sbd.append("a");
				}
				
			}).start();
		}
		
		// 保证所有线程结束
		for (int i = 10; i > 0; i--) {
			try {
				System.out.println(i + "秒后打印结果");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// StringBuffer的结果保证是100000
		System.out.println(sbf.length());
		// StringBuilder的结果时不时会出现少于100000的
		System.out.println(sbd.length());
	}

}
