package finalTest.finalTest01;

public class FinalTest {

	public void changeString(String str) {
		str = "kk";
	}
	
//	public void changeString2(final String str) {
//		str = "kk";
//	}
	
	public static void main(String[] args) {
		String str = "dd";
		new FinalTest().changeString(str);
		System.out.println(str);
	}

}
