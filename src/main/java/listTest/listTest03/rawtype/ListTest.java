package listTest.listTest03.rawtype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(1);
		list.add("hello");
		list.add(true);
		list.add(new BigDecimal("12346.461564"));
		System.out.println(list);
	}

}
