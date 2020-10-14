package aopTest.aopTest02;

public class UserServiceImpl implements UserService {
	public void addUser(User user) {
		System.out.println("add user into database.");
	}

	public User getUser(int id) {
		User user = new User();
		user.setId(id);
		System.out.println("getUser from database.");
		return user;
	}
}