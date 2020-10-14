package aopTest.aopTest06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:F:/project/CodeTest/src/aopTest/aopTest06/applicationContext.xml");
		Sleepable s = (Sleepable) ctx.getBean("lida");
		s.sleep();
	}

}
