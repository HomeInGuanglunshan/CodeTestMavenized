package design.patterns.strategy.p02;

public class Car extends Benz implements Wheel {

	@Override
	public void run() {
		System.out.println(this + " is running");
		leakOil();
	}

	public static void main(String[] args) {
		new Car().run();
	}
}
