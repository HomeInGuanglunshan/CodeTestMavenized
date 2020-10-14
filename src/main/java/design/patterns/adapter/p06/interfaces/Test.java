package design.patterns.adapter.p06.interfaces;

public class Test {

	public static void main(String[] args) {
		Female mother = new Mother();
		Female nurse = new Nurse();
		Female girl = new Girl();
		Female bitch = new Bitch();

		mother.born();
		nurse.nurse();
		girl.actUp();
		bitch.suck();
	}

}
