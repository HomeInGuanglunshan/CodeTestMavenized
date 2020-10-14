package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest02 {

	public static void main(String[] args) {
		String[] foos = { "foo1", "foo2", "foo3", "foo4" };
		List<String> fooList = Arrays.asList(foos);
		fooList.stream();
	}

}
