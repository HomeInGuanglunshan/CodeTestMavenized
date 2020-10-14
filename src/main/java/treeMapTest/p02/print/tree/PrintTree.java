package treeMapTest.p02.print.tree;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PrintTree {

	static Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	static String space = "\u0020\u0020\u0020";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 6; i++) {
			map.put(i, i);
		}

		Field field = map.getClass().getDeclaredField("root");
		field.setAccessible(true);
		Entry<Integer, Integer> root = (Entry<Integer, Integer>) field.get(map);

		int height = getTreeHeight(root);
		List<Entry<Integer, Integer>> entryList = new LinkedList<Entry<Integer, Integer>>();
		entryList.add(root);
		printTree(entryList, height);
	}
	
	@SuppressWarnings("unchecked")
	public static void printTree(List<Entry<Integer, Integer>> entryList, int height) throws Exception {
		if (height == 0) {
			return;
		}
		for (int i = 0; i < (1 << (height - 1)) - 1; i++) {
			System.out.print(space);
		}
		StringBuffer entryspace = new StringBuffer();
		for (int i = 0; i < (1 << height) - 1; i++) {
			entryspace.append(space);
		}
		StringBuffer line = new StringBuffer();
		List<Entry<Integer, Integer>> nextEntryList = new LinkedList<Entry<Integer, Integer>>();
		for (Iterator<Entry<Integer, Integer>> it = entryList.iterator(); it.hasNext();) {
			Entry<Integer, Integer> entry = it.next();
			if (null == entry) {
//				line.append("<nil, nil>");
				line.append("\u2588\u2588\u2588");
				line.append(entryspace);
				nextEntryList.add(null);
				nextEntryList.add(null);
				continue;
			} else {

				Field field = entry.getClass().getDeclaredField("color");
				field.setAccessible(true);
				boolean color = (boolean) field.get(entry);
				String redOrBlack = color ? "B" : "R";

//				String strToPrint = "<" + entry.getKey() + " ," + entry.getValue() + ">";
//				strToPrint = (strToPrint + space).substring(0, 10);

				String strToPrint = entry.getKey() + redOrBlack;
				strToPrint = (strToPrint + space).substring(0, space.length());
				line.append(strToPrint);
				line.append(entryspace);
			}

			Field field = entry.getClass().getDeclaredField("left");
			field.setAccessible(true);
			Entry<Integer, Integer> left = (Entry<Integer, Integer>) field.get(entry);

			field = entry.getClass().getDeclaredField("right");
			field.setAccessible(true);
			Entry<Integer, Integer> right = (Entry<Integer, Integer>) field.get(entry);

			nextEntryList.add(left);
			nextEntryList.add(right);
		}
		System.out.println(line);
		printTree(nextEntryList, --height);
	}
	
	/**
	 * 最左的一个叶子节点到根节点的层数
	 * @param entry
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static int countTiers(Entry<Integer, Integer> entry) throws Exception {
		if (null == entry) {
			return 0;
		}
		int tiers = 1;
		Field field = entry.getClass().getDeclaredField("left");
		field.setAccessible(true);
		Entry<Integer, Integer> left = (Entry<Integer, Integer>) field.get(entry);
		while (null != left) {
			tiers++;
			entry = left;
			field = entry.getClass().getDeclaredField("left");
			field.setAccessible(true);
			left = (Entry<Integer, Integer>) field.get(entry);
		}
		return tiers;
	}
	
	/**
	 * 获取树的高度
	 * @param entry
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static int getTreeHeight(Entry<Integer, Integer> entry) throws Exception {
		if (entry == null) {
			return 0;
		} else {
			Field field = entry.getClass().getDeclaredField("left");
			field.setAccessible(true);
			Entry<Integer, Integer> left = (Entry<Integer, Integer>) field.get(entry);
			
			field = entry.getClass().getDeclaredField("right");
			field.setAccessible(true);
			Entry<Integer, Integer> right = (Entry<Integer, Integer>) field.get(entry);

			return 1 + Math.max(getTreeHeight(left), getTreeHeight(right));
		}
	}
}
