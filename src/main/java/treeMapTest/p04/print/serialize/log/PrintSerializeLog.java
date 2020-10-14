package treeMapTest.p04.print.serialize.log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.util.Log4jConfigurer;

public class PrintSerializeLog {

	static {
		try {
			Log4jConfigurer.initLogging(PrintSerializeLog.class.getResource("log4j.xml").getFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	static Logger logger = Logger.getLogger(PrintSerializeLog.class);
	static Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
	static String space = "\u0020\u0020\u0020";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		for (;;) {
			try {
				input = br.readLine();
				logger.debug(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (input.matches("(\\+|\\-)(0|[1-9][0-9]*)")) {
				prepareToPrintTree(input);
			} else if ("save".equals(input)) {
				saveTree();
			} else if ("load".equals(input)) {
				loadTree();
			} else {
				logger.error("invalid input");
				continue;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void prepareToPrintTree(String input) throws Exception {
		String putOrRemove = null;
		Integer number = null;
		Matcher m = Pattern.compile("(\\+|\\-)(0|[1-9][0-9]*)").matcher(input);
		while (m.find()) {
			putOrRemove = m.group(1);
			number = Integer.valueOf(m.group(2));
		}
		
		if ("+".equals(putOrRemove)) {
			map.put(number, number);
		} else if ("-".equals(putOrRemove)) {
			map.remove(number);
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
	private static void printTree(List<Entry<Integer, Integer>> entryList, int height) throws Exception {
		if (height == 0) {
			return;
		}
		StringBuffer line = new StringBuffer();
		for (int i = 0; i < (1 << (height - 1)) - 1; i++) {
			line.append(space);
		}
		StringBuffer entryspace = new StringBuffer();
		for (int i = 0; i < (1 << height) - 1; i++) {
			entryspace.append(space);
		}
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
		logger.info(line);
		printTree(nextEntryList, --height);
	}
	
	private static void saveTree() throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("F:/project/CodeTest/src/treeMapTest/p04/print/serialize/log/serializedMap"));
		oos.writeObject(map);
		logger.error("save successfully!");
		oos.close();
	}

	@SuppressWarnings("unchecked")
	private static void loadTree() throws Exception {
		if (map != null && map.size() > 0) {
			logger.error("The tree map is not empty, are you sure to reload from the file?(Y/N)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = null;
			for (;;) {
				try {
					input = br.readLine();
					logger.debug(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if ("Y".equalsIgnoreCase(input)) {
					break;
				} else if ("N".equalsIgnoreCase(input)) {
					return;
				} else {
					logger.error("invalid input");
					continue;
				}
			}
		}
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("F:/project/CodeTest/src/treeMapTest/p04/print/serialize/log/serializedMap"));
		map = (Map<Integer, Integer>) ois.readObject();
		logger.error("load successfully!");
		prepareToPrintTree("");
		ois.close();
	}
	
	/**
	 * 最左的一个叶子节点到根节点的层数
	 * @param entry
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private static int countTiers(Entry<Integer, Integer> entry) throws Exception {
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
	private static int getTreeHeight(Entry<Integer, Integer> entry) throws Exception {
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
