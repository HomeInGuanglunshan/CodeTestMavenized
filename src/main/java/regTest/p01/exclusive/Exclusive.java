package regTest.p01.exclusive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exclusive {

	public static void main(String[] args) {
//		String regex = "^((?!19\\d\\d)\\d)+$";
//		String text = "46464454";
//		Matcher matcher = Pattern.compile(regex).matcher(text);
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
		String regex = "^((?!hede).)*$";
		String text = "46464454";
//		String text = "46464hede454";
		Matcher matcher = Pattern.compile(regex).matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		
//		String regex = "[^hede]+";
////		String text = "46464454";
//		String text = "46464hede454";
//		Matcher matcher = Pattern.compile(regex).matcher(text);
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
	}
}
