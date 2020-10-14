package contextannotation.config.vs.contextcomponent.scan.p03.com.yyy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import contextannotation.config.vs.contextcomponent.scan.p03.com.xxx.B;
import contextannotation.config.vs.contextcomponent.scan.p03.com.xxx.C;

@Component
public class A {
	private B bbb;
	private C ccc;

	public A() {
		System.out.println("creating bean A: " + this);
	}

	@Autowired
	public void setBbb(B bbb) {
		System.out.println("setting A.bbb with " + bbb);
		this.bbb = bbb;
	}

	@Autowired
	public void setCcc(C ccc) {
		System.out.println("setting A.ccc with " + ccc);
		this.ccc = ccc;
	}
}