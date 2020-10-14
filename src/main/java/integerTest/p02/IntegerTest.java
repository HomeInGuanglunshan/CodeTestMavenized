package integerTest.p02;

public class IntegerTest {

	public static void main(String[] args) {
		MyInteger myInteger = new MyInteger(5);
		Integer myVal = myInteger.getVal();
		for (int i = 0; i < 5; i++) {
			myVal--;
		}
		System.out.println(myVal);
		System.out.println(myInteger.getVal());
		myVal = null;
		System.out.println(myInteger.getVal());
	}

}

class MyInteger {
	
	Integer val;

	public MyInteger(Integer val) {
		super();
		this.val = val;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}
	
}
