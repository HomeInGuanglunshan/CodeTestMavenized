package design.patterns.adapter.p06.interfaces;

public class Girl extends FemaleAdapter {

	@Override
	public void actUp() {
		System.out.println("Treat or trick");
	}

}
