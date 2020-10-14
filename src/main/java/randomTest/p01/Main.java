package randomTest.p01;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++) {
			System.out.println(new Random().nextInt(26) + 1);
		}
	}

}
