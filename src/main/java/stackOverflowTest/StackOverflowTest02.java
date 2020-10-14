package stackOverflowTest;

public class StackOverflowTest02 {

	StackOverflowTest02 instance = new StackOverflowTest02();

}

class mine {
	
	public static void main(String[] args) {
		new StackOverflowTest02();
	}
	
}