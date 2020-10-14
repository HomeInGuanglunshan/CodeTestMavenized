package contextannotation.config.vs.contextcomponent.scan.p02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"contextannotation/config/vs/contextcomponent/scan/p02/applicationContext.xml");
	}
}
