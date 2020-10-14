package treeMapTest.p01;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? -1 : 1;
//				return o1 == o2 ? 0 : o1 > o2 ? -1 : 1;
			}
		});
		map.put(1, 1);
		map.put(3, 3);
		map.put(2, 2);
		map.put(4, 4);
		map.put(5, 5);
		map.put(9, 9);
		map.put(6, 6);
		map.put(11, 11);
		map.put(11, 11);
		map.put(8, 8);
		map.put(7, 7);
		map.put(10, 10);
		System.out.println(map);
	}

}
