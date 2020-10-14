package aopTest.aopTest11_stringBuffer;

public class Class4StringBuffer implements CommonInterface {

	@Override
	public <T> void addSth(StringBuffer sb, T sth) {
		sb.append(sth);
	}

}
