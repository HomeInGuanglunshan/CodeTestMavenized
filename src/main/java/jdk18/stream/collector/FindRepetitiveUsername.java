package jdk18.stream.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/weixin_44420955/article/details/101219643
 */
public class FindRepetitiveUsername {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("xpf1", "1238", 18));
		users.add(new User("xpf2", "1234", 18));
		users.add(new User("xpf3", "1235", 18));
		users.add(new User("xpf", "1236", 18));
		users.add(new User("xpf", "1237", 18));
		Map<String, Long> collect = users.stream().map(User::getUserName)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<String> result = new ArrayList<>();
		collect.forEach((k, v) -> {
			if (v > 1)
				result.add(k);
		});
		System.out.println(result.toString());

	}

}
