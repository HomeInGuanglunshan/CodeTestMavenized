package aopTest.aopTest05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:F:/project/CodeTest/src/aopTest/aopTest05/applicationContext.xml");
		// 以下两行都成功运行
		// ((Lida) (new Lida())).sleep();
		// ((Sleepable) (new Lida())).sleep();
		Sleepable s = (Sleepable) ctx.getBean("lidaProxy"); // 此处和aopTest4有不同
		s.sleep();
		// 输出 com.sun.proxy.$Proxy0
		// System.out.println(ctx.getBean("lida").getClass().getName());
		/**
		 * code below throws exception : com.sun.proxy.$Proxy0 cannot be cast to
		 * aopTest.aopTest4.Lida
		 */
		// Lida l = (Lida) ctx.getBean("lida");
		// l.sleep();
	}

}
