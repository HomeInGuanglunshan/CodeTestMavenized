package design.patterns.handler.p01;

public class TestByMe {

	public static void main(String[] args) {
		MyHandler myHandler = new MyHandler("myHandler ");
		myHandler.setHandler(() -> {
			System.out.println("My handler was invoked");
		});
		myHandler.operator();
	}

}
