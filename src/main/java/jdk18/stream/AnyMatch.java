package jdk18.stream;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {

	public static void main(String[] args) {
		List<String> fooList = Arrays.asList("foo1", "foo2", "foo3", "foo4");
		System.out.println(fooList.stream().anyMatch(foo -> foo.indexOf("foo") == 0));

		List<String> barList = Arrays.asList("bar1", "bar2", "bar3", "foo4");
		System.out.println(barList.stream().anyMatch(bar -> bar.indexOf("foo") == 0));
	}

}
