package regTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest8 {
	public static void main(String[] args) throws Exception {

		String text = "全家人	（你好）	 WHOLE_FAMILY_";

		Matcher m = Pattern.compile("(.*)\\s(\\w+)").matcher(text);

		while (m.find()) {
			System.out.println(m.group(1).trim() + ":" + m.group(2).trim());
		}
		
	}
}
