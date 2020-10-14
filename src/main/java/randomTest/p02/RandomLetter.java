package randomTest.p02;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class RandomLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArr = new char[20];
		for (int i = 0; i < charArr.length; i++) {
			charArr[i] = (char) (new Random().nextInt(26) + 97);
		}
		System.out.println(charArr);
		TreeSet<Character> ts = new TreeSet<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				int num1 = o1 - o2;
				return num1;
			}
			
		});
		for (int i = 0; i < charArr.length; i++) {
			ts.add(charArr[i]);
		}
		System.out.println(ts);
	}

}
