package write.from.memory.treeset.comparable;

public class Student implements Comparable<Student> {
	
	private String name;

	private int age;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		int num1 = this.name.length() - s.name.length();
		int num2 = num1 == 0 ? this.name.compareTo(s.name) : num1;
		int num3 = num2 == 0 ? this.age - s.age : num2;
		return num3;
	}

}
