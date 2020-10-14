package annotation.p08.proxy.cglib;

public class Main {

	public static void main(String[] args) {
		Action action = ProxyUtil.getProxy(Action.class);
		action.sleep();
		action.washFace();
		action.eat();
	}

}
