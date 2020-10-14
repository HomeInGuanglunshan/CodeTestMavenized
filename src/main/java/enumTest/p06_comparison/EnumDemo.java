package enumTest.p06_comparison;

public class EnumDemo {

	public static void main(String[] args) {
//		String myCar = "GEELY";
//		for (Car car : Car.values()) {
//			if (myCar.equals(car)) {
//				System.out.println("It's my car");
//			} else {
//				System.out.println(car + " is not my car, my car is " + myCar);
//			}
//		}
		
//		Car myCar = Car.GEELY;
//		for (Car car : Car.values()) {
//			if (myCar.equals(car)) {
//				System.out.println("It's my car " + car);
//			} else {
//				System.out.println(car + " is not my car, my car is " + myCar);
//			}
//		}
		
		Car myCar = Car.GEELY;
		for (Car car : Car.values()) {
			if (myCar == car) {
				System.out.println("It's my car " + car);
			} else {
				System.out.println(car + " is not my car, my car is " + myCar);
			}
		}
	}
}

enum Car {
	BENZ, TOYOTA, GEELY, FORD, BYD
}