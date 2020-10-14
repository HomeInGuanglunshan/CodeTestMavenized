package design.patterns.adapter.p06.interfaces;

public class Nurse extends FemaleAdapter {

	@Override
	public void nurse() {
		System.out.println("The patient looks well today");
	}

}
