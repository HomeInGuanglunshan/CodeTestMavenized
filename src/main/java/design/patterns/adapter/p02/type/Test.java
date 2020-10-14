package design.patterns.adapter.p02.type;

public class Test {

	public static void main(String[] args) {
		Cement cement = new MudAdapter();
		cement.mix();
	}

}
