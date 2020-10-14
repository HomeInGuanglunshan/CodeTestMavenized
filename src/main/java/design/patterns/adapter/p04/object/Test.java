package design.patterns.adapter.p04.object;

public class Test {

	public static void main(String[] args) {
		ExodiaTheForbiddenOne exodia = new YuGiOh(new RightArmOfTheForbiddenOne(), new LeftArmOfTheForbiddenOne(),
				new RightLegOfTheForbiddenOne(), new LeftLegOfTheForbiddenOne());
//		ExodiaTheForbiddenOne exodia = new YuGiOh(null, new LeftArmOfTheForbiddenOne(), new RightLegOfTheForbiddenOne(),
//				new LeftLegOfTheForbiddenOne());
		exodia.unforbidden();
	}

}
