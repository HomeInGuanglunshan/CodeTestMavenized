package jdk18.foreach;

import java.util.Arrays;
import java.util.List;

public class Foreach01 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		list.forEach((item) -> {
			System.out.println(item);
		});
	}

}
