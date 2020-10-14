package forTest;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public class ForTest {

	public static void main(String[] args) {
//		for (int i = 0; i < 10; ++i) {
//			System.out.println(i);
//		}
		List<Record> list = new ArrayList<Record>();
		for(Record i : list) {
			System.out.println("hello");
		}
	}

}
