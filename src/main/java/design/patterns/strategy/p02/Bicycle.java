package design.patterns.strategy.p02;

public class Bicycle extends Armstrong implements Wheel {

	@Override
	public void run() {
		System.out.println(this + " is riding so fast");
	}

	public static void main(String[] args) {
		new Bicycle().run();
	}
}
