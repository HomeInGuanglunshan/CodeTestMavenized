package regTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex = "^123";
		String str = "124";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		boolean result =  matcher.matches();
		System.out.println(result);
	}

}
