package ternary.operator.test.p01;

public class TernaryOperatorTest {

//	模仿jdk1.7HashMap的roundUpToPowerOf2方法
//  private static int roundUpToPowerOf2(int number) {
//      // assert number >= 0 : "number must be non-negative";
//      int rounded = number >= MAXIMUM_CAPACITY
//              ? MAXIMUM_CAPACITY
//              : (rounded = Integer.highestOneBit(number)) != 0
//                  ? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded
//                  : 1;
//
//      return rounded;
//  }
//	层级
//	1 2 3
//	3.1 3.2 3.3
//	3.2.1 3.2.2 3.2.3
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int a = 9 > 10 ? 10 :
			8 > 7 ?
			6 > 5 ? 6 : 5 
			: Integer.MAX_VALUE;
		System.out.println(a);
	}
	
}
