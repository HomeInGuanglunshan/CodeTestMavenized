package aopTest.aopTest07;

public class SleepHelper {
	public void beforeSleep() {
		System.out.println("睡觉前要敷面膜");
	}

	public void afterSleep() {
		System.out.println("睡觉后要做美梦");
	}
}