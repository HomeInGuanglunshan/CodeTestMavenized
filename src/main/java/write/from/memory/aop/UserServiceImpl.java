package write.from.memory.aop;

public class UserServiceImpl implements UserService {

	public User getUser() {
		return new User();
	}
	
	public void setUser(User user) {
		
	}
}
