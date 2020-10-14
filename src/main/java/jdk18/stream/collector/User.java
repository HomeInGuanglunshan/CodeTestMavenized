package jdk18.stream.collector;

/**
 * https://blog.csdn.net/weixin_44420955/article/details/101219643
 */
public class User {

	private String userName;

	private String password;

	private Integer age;

	public User(String userName, String password, Integer age) {
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
