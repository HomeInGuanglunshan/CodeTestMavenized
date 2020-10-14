package jdk18.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {
		String[] bars = { "bar1", "bar2", "bar3", "bar4" };
		List<String> barList = Arrays.asList(bars);

		System.out.println(barList);

		barList.forEach(bar -> {
//			java.lang.UnsupportedOperationException
//			barList.remove(bar);

			System.out.println(bar);
		});

		System.out.println("------------------------------------------------------------");

		barList.stream().forEach(bar -> {
//			java.lang.UnsupportedOperationException
//			barList.remove(bar);

			System.out.println(bar);
		});

		System.out.println("------------------------------------------------------------");

		for (Iterator<String> iterator = barList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
//			java.lang.UnsupportedOperationException
//			iterator.remove();
		}

		List<String> fooList = new ArrayList<>();
		fooList.add("foo1");
		fooList.add("foo2");
		fooList.add("foo3");

		System.out.println("------------------------------------------------------------");

		for (Iterator<String> iterator = fooList.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next()); // 必须一边迭代一边删除
			iterator.remove();
		}

		System.out.println(fooList);
	}

}
