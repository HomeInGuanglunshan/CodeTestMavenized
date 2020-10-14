package jdk18.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sorted {

	public static void main(String[] args) {
		String[] keys = { "key2", "key4", "key6", "key8", "key10" };
		Set<String> keySet = new HashSet<String>(Arrays.asList(keys));
		System.out.println(keySet);

		keySet.stream().sorted((o1, o2) -> {
			Integer suffix1 = Integer.valueOf(o1.replaceAll(".*?(\\d+)", "$1"));
			Integer suffix2 = Integer.valueOf(o2.replaceAll(".*?(\\d+)", "$1"));
			return suffix1.compareTo(suffix2);
		}).forEach(key -> System.out.println(key));
	}

}
