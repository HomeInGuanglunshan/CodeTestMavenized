package mapTest.p03.redblacktree;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FilledTableTreeified {

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>(4, 20);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Entry<Integer, Integer>[] table = null;
		for (int i = 0; i < 600; i++) {
			map.put(i, i);
		}
		try {
			Field field = map.getClass().getDeclaredField("table");
			field.setAccessible(true);
			table = (Entry<Integer, Integer>[]) field.get(map);
			
			for (int i = 0; i < table.length; i++) {
				Entry<Integer, Integer> e = table[i];
				while (e != null) {
					System.out.print(e.getValue() + " -> ");
					field = e.getClass().getDeclaredField("next");
					field.setAccessible(true);
					e = (Entry<Integer, Integer>) field.get(e);
				}
				System.out.println();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
