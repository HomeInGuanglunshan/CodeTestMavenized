package mapTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest3 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		System.out.println(map);
		Map<String, String> m2 = new HashMap<String, String>(map);
		m2.put("3", "3");
		System.out.println(m2);
		m2.remove("2");
		System.out.println(m2);
	}

}
