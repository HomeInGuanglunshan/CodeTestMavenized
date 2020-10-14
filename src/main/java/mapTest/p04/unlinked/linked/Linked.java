package mapTest.p04.unlinked.linked;

import java.util.LinkedHashMap;
import java.util.Map;

public class Linked {

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put("foo" + i, "bar" + i);
		}
		System.out.println(map);
	}

}
