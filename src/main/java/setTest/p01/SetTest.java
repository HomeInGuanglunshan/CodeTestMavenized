package setTest.p01;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<User> set = new HashSet<User>();
		User user1 = new User("li", "male");
		User user2 = new User("Yang", "male");
		User user3 = new User("Huang", "male");
		User user4 = new User("Huang", "male");
		set.add(user1);
		set.add(user2);
		set.add(user3);
		set.add(user4);
		System.out.println(set);
		set.remove(user1);
		System.out.println(set);
	}

}
