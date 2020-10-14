package forTest;

public class ForTest2 {

	public static void main(String[] args) {
		test: for (int i = 0; i < 10; ++i) {
			if (i == 5) {
				continue test;
			}
			System.out.println(i);
		}
	}

}
