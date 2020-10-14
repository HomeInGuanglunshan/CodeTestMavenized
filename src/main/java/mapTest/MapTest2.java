package mapTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		List<Map<String, String>> l = new ArrayList<Map<String, String>>();
		List<Map<String, String>> l2 = new ArrayList<Map<String, String>>();
		Map map = new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		Map m2 = map;
		m2.put("3", "3");
		m2.remove("2");
		l2 = l;
		l.add(map);
		System.out.println(l);
		System.out.println(l2);
	}

}
