package mapTest.p01.iterator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sgsfg", "1");
		map.put("safsv", "2");
		map.put("3uyijy", "3");
		map.put("et6jgh4", "4");
		for (Iterator<Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + "---" + entry.getValue());
		}
		
//		Map<?, ?> emptyMap = Collections.EMPTY_MAP;
//		System.out.println(emptyMap);
		
		System.out.println(map.put("sgsfg", "34456"));
	}

}
