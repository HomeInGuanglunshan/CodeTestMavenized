package contextannotation.config.vs.contextcomponent.scan.p01.com.yyy;

import contextannotation.config.vs.contextcomponent.scan.p01.com.xxx.B;
import contextannotation.config.vs.contextcomponent.scan.p01.com.xxx.C;

public class A {
	private B bbb;
	private C ccc;

	public A() {
		System.out.println("creating bean A: " + this);
	}

	public void setBbb(B bbb) {
		System.out.println("setting A.bbb with " + bbb);
		this.bbb = bbb;
	}

	public void setCcc(C ccc) {
		System.out.println("setting A.ccc with " + ccc);
		this.ccc = ccc;
	}
}