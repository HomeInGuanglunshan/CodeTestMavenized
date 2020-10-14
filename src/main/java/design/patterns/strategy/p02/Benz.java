package design.patterns.strategy.p02;

public abstract class Benz {

	public void leakOil() {
		for (;;) {
			System.out.println("Oil");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Benz";
	}

}
