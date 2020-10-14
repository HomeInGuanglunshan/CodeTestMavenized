package annotation.p10.spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:" + Main.class.getResource("applicationContext.xml").getFile());
		Action action = (Action) context.getBean(Action.class);
		action.eat();
	}

}
