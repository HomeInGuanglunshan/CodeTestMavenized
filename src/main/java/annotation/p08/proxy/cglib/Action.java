package annotation.p08.proxy.cglib;

public class Action {

	public void wakeUp() {
		System.out.println("wake up");
	}

	public void brushTeeth() {
		System.out.println("brush teeth");
	}

	@Proxy(before = "masturbate", after = "ride")
	public void washFace() {
		System.out.println("wash face");
	}

	public void cook() {
		System.out.println("cook");
	}

	@Proxy(before = "cook", after = "masturbate")
	public void eat() {
		System.out.println("eat");
	}

	public void sweep() {
		System.out.println("sweep");
	}

	public void ride() {
		System.out.println("ride");
	}

	@Proxy(before = "washFace", after = "wakeUp")
	public void sleep() {
		System.out.println("sleep");
	}
}
