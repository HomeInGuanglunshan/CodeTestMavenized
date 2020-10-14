package listTest.listTest01;

import java.util.ArrayList;

public class ListTest01 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("" + i);
		}
//		String[] array = (String[]) list.toArray();
		String[] array = list.toArray(new String[0]);
		for (String s : array) {
			System.out.println(s);
		}
	}

}
