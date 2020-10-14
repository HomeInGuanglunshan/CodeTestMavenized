package treeMapTest.p01;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest02 {

	public static void main(String[] args) {

//		默认按key升序排序，不允许重复key的存在
//		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? -1 : 1;
//				return o1 == o2 ? 0 : o1 > o2 ? -1 : 1;
			}
		});

		map.put(12, 1);
		map.put(31, 3);
		map.put(24, 2);
		map.put(45, 4);
		map.put(52, 5);
		map.put(19, 9);
		map.put(26, 6);
		map.put(11, 11);
		map.put(11, 11);
		map.put(38, 8);
		map.put(77, 7);
		map.put(10, 10);

		System.out.println(map);

//		有比较器时，get到的居然是null，即使去掉两个map.put(11, 11);的其中一个也不行
//		无比较器时，顺利get到
//		System.out.println(map.get(11));
	}

}
