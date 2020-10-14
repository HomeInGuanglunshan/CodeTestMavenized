package treeMapTest.p05.male.female;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MaleFemale {

	public static void main(String[] args) {
		TreeMap<Long, String> treeMap = new TreeMap<>();
		for (int i = 0; i < 100; i++) {
			treeMap.put(System.currentTimeMillis(), i % 2 == 0 ? "女" : "男");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(treeMap);

		for (Iterator<Entry<Long, String>> iterator = treeMap.entrySet().iterator(); iterator.hasNext();) {
			Entry<Long, String> entry = iterator.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

}
