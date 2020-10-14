package regTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest6 {
	public static void main(String[] args) throws Exception {

//		String text = "auser1 home1b\n" + "auser2 home2b\n" + "auser3 home3b";
//
//		Matcher m = Pattern.compile("(?m)^.*$").matcher(text);
//
//		while (m.find()) {
//			System.out.println("line = " + m.group());
//		}
		
//		String text = "dfgsdfg";
//
//		Matcher m = Pattern.compile("(.?)(.*)").matcher(text);
//
//		while (m.find()) {
//			System.out.println(m.group(1).toUpperCase() + m.group(2));
//		}
		
//		String text = "  全家人		 WHOLE_FAMILY_";
		String text = "WHOLE_FAMILY_  		";

		Matcher m = Pattern.compile("(\\S+)\\s*(\\S*)").matcher(text);

		while (m.find()) {
			System.out.println(m.group(1) + ":" + m.group(2));
		}
		
//		String text = "bbbbbba";
//
//		Matcher m = Pattern.compile("b*").matcher(text);
//
//		while (m.find()) {
//			System.out.println(m.group());
//		}
	}
}
