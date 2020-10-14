package annotation.p09.proxy.jdk.dynamic;

public class ActionImpl implements Action {

	@Override
	public void wakeUp() {
		System.out.println("wake up");
	}

	@Override
	public void brushTeeth() {
		System.out.println("brush teeth");
	}

	@Override
	@ProxyAnnotation(before = "masturbate", after = "ride")
	public void washFace() {
		System.out.println("wash face");
	}

	@Override
	public void cook() {
		System.out.println("cook");
	}

	@Override
	@ProxyAnnotation(before = "cook", after = "masturbate")
	public void eat() {
		System.out.println("eat");
	}

	@Override
	public void sweep() {
		System.out.println("sweep");
	}

	@Override
	public void ride() {
		System.out.println("ride");
	}

	@Override
	@ProxyAnnotation(before = "washFace", after = "wakeUp")
	public void sleep() {
		System.out.println("sleep");
	}
}
