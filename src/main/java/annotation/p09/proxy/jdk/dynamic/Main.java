package annotation.p09.proxy.jdk.dynamic;

public class Main {

	public static void main(String[] args) {
		Action action = ProxyUtil.getProxy(ActionImpl.class);
		action.sleep();
		action.washFace();
		action.eat();
	}

}
