package jdk18.lambda.p08;

public class Test {

	public static void main(String[] args) {
		God god = new God();
		god.create((water, food, air) -> water.wet());
		god.testHuman();
	}

}
