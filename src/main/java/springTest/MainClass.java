package springTest;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("springTest/testSetter.xml");
		System.out.println(ac.getBean("testA", TestA.class));
	}

	@Test(expected = BeanCurrentlyInCreationException.class)
	public void testCircleByConstructor() throws Throwable {
		try {
			new ClassPathXmlApplicationContext("springTest/testConstructor.xml");
		} catch (Exception e) {
			// 因为要在创建testC时抛出；
			Throwable e1 = e.getCause().getCause().getCause();
			throw e1;
		}
	}

	@Test(expected = BeanCurrentlyInCreationException.class)
	public void testCircleBySetterAndPrototype() throws Throwable {
		try {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springTest/testPrototype.xml");
			System.out.println(ctx.getBean("testA"));
		} catch (Exception e) {
			Throwable e1 = e.getCause().getCause().getCause();
			throw e1;
		}
	}
}
