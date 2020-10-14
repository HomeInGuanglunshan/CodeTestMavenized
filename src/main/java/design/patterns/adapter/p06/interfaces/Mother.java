package design.patterns.adapter.p06.interfaces;

public class Mother extends FemaleAdapter {

	@Override
	public void born() {
		System.out.println("The Mother borned a baby");
	}

}
