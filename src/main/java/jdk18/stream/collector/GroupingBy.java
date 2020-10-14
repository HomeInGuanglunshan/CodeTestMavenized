package jdk18.stream.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("lida", "1238", 27));
		users.add(new User("likui", "1234", 27));
		users.add(new User("yang", "1235", 27));
		users.add(new User("chen", "1236", 27));
		users.add(new User("huang", "1237", 26));

		System.out.println(users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting())));
		System.out.println(users.stream().collect(Collectors.groupingBy(User::getAge)));
		System.out.println(users.stream().collect(
				Collectors.groupingBy(User::getAge, Collectors.mapping(User::getUserName, Collectors.toList()))));
	}

}
