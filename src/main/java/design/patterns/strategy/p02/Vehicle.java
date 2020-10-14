package design.patterns.strategy.p02;

public class Vehicle extends Container implements Wheel {

	@Override
	public void run() {
		System.out.println("I am a container vehicle running on high way");
		getContainerStatus();
	}

	public static void main(String[] args) {
		new Vehicle().run();
	}
}
