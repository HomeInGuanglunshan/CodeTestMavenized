package design.patterns.adapter.p02.type;

public class MudAdapter extends Water implements Cement {

	@Override
	public String solid() {
		return "mud";
	}

	@Override
	public void mix() {
		System.out.println("mix " + solid() + " with " + liquid() + ", then will get cement");
	}

}
