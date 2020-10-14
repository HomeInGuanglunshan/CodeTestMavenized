package design.patterns.adapter.p05.interfaces;

public class SourceSub2 extends Wrapper2 {
	@Override
	public void method2() {
		System.out.println("the sourceable interface's second Sub2!");
	}
}
