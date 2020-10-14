package setTest.p01;

public class User {

	String name;
	
	String sex;

	public User(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String toString() {
		return "name:" + this.name + "|sex:" + this.sex;
	}
}
