package jdk18.lambda.p08;

public class God {

	Human human;

	public void create(Human human) {
		System.out.println("A human is created");
		this.human = human;
	}

	public void testHuman() {
		System.out.println("=--------- Test Human ----------");
		human.live(new Water(), new Food(), new Air());
		System.out.println("---------- Test Human ---------=");
	}

}
