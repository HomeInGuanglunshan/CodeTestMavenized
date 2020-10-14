package regTest.p02.number.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) {
		System.out.println("3253".matches("^0|[1-9][0-9]*$"));
		System.out.println("0253".matches("^0|[1-9][0-9]*$"));
		System.out.println("+253".matches("(\\+|\\-)(0|[1-9][0-9]*)"));
		System.out.println("++253".matches("(\\+|\\-)(0|[1-9][0-9]*)"));
		
		String putOrRemove = null;
		Integer number = null;
		Matcher m = Pattern.compile("^(\\+|\\-)(0|[1-9][0-9]*)$").matcher("-23465");
		while (m.find()) {
			putOrRemove = m.group(1);
			number = Integer.valueOf(m.group(2));
		}
		System.out.println(putOrRemove);
		System.out.println(number);
	}
}
