package inheritableThreadLocalTest.p01;

public class InheritableThreadLocalTest {

	public static void main(String[] args) {
		
		final ThreadLocal threadLocal = new ThreadLocal() {
			@Override
			protected Object initialValue() {
				return "xiezhaodong";
			}
		};
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(threadLocal.get()); // NULL
			}
		}).start();
	}

}
