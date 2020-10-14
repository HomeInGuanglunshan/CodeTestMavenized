package integerTest.p01;

public class IntegerTest {

	public static Integer TULUFAN = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer target = new Integer(3);
		System.out.println(target == TULUFAN);
		System.out.println(target == 3);
		System.out.println(TULUFAN.equals(target));
	}

}
