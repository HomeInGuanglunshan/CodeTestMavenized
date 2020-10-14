package contextannotation.config.vs.contextcomponent.scan.p03.com.xxx;

import org.springframework.stereotype.Component;

@Component
public class B {
	public B() {
		System.out.println("creating bean B: " + this);
	}
}